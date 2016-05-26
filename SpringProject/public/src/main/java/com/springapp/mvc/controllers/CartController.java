package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.aspects.annotation.Log;
import mvc.common.Cart;
import mvc.common.GoodInfo;
import mvc.common.Goods_users;
import mvc.common.UsersInfo;
import mvc.services.CartService;
import mvc.services.GoodService;
import mvc.services.GoodsUsersService;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsUsersService goods_users;

    /**
     * Отображение содержимого корзины
     */
    @IncludeMenuInfo
    @RequestMapping
    public String renderCart() {

//        UsersInfo user = userService.getByLogin(request.getUserPrincipal().getName());
//        request.setAttribute("cart",cartService.getByUser(user));
        return "cart/cartPage";
    }

    /**
     * Добавление товара в корзину
     *
     * @param goodId id товара
     */
    @Log
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId,Model model) {
        goodService.popularUp(goodId);
        Cart cart = new Cart();
        GoodInfo good = goodService.getById(goodId);
        good.setCount(good.getCount()-1);
        goodService.update(good);
        cart.setGood_id(good);
        cart.setCount(1L);
        if(request.getRemoteUser() != null) {
            UsersInfo user = userService.getByLogin(request.getUserPrincipal().getName());
            cart.setUser_id(user);
            List<Cart> dbCart = cartService.getByUser(user);

            //Добавление в таблицу goods_users для подбирания рекомендаций для пользователя
            Goods_users gu = new Goods_users();
            gu.setGoodInfo(goodService.getById(goodId));
            gu.setUsersInfo(user);
            goods_users.add(gu);

            for (Cart c : dbCart){
                if(c.getGood_id().getId().equals(goodId)){
                    model.addAttribute("cart",request.getSession().getAttribute("cart"));
                    cart.setCount(c.getCount()+1);
                    cartService.delete(user.getId(),goodId);
                    cartService.addInCart(cart);
                }
            }

            cartService.addInCart(cart);
            model.addAttribute("cart",dbCart);
        }else {
             cartService.addInCart(request.getSession(),goodId, 1);
        }
//        if(request.getRemoteUser() != null) {
//            UsersInfo user = userService.getByLogin(request.getUserPrincipal().getName());
//            cartService.addInCart(user.getId(), goodId, 1L);
//        }else {
//            cartService.addInCart(request.getSession(), goodId, 1);
//        }
//        request.setAttribute("cart",cartList);



        cartService.addInCart(request.getSession(),goodId,1);
        return "ok";
    }
//
//    @ResponseBody
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String deleteGood(Long goodId,Model model) {
//        List<GoodInfo> cart = (List<GoodInfo>) request.getAttribute("cart");
//        for (GoodInfo good : cart ){
//            if(good.getId().equals(goodId)){
//                cart.remove(good);
//            }
//        }
//        request.setAttribute("cart",cart);
//        return "ok";
//    }

}