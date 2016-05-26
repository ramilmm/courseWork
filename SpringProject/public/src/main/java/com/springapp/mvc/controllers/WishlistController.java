package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import mvc.common.GoodInfo;
import mvc.common.UsersInfo;
import mvc.common.WishlistInfo;
import mvc.services.GoodService;
import mvc.services.UserService;
import mvc.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WishlistController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private WishlistService wishlist;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodService goodService;

    @IncludeMenuInfo
    @RequestMapping(value = "/wishlist", method = RequestMethod.GET)
    public String renderWishlist(){
        if(request.getRemoteUser() != null){
            request.setAttribute("wishlist",wishlist.getByUser_login(request.getUserPrincipal().getName()));
        }else {
            request.setAttribute("wishlist", request.getAttribute("anon_wishlist"));
        }
        return "wishlist/wishlistPage";
    }
    @ResponseBody
    @RequestMapping(value = "/wishlist/add",method = RequestMethod.POST)
    public String addInWishlist(Long goodId, Model model){
        goodService.popularUp(goodId);
        GoodInfo good = goodService.getById(goodId);
        good.setCount(good.getCount()-1);
        goodService.update(good);
        if(request.getRemoteUser() != null){
            UsersInfo user = userService.getByLogin(request.getUserPrincipal().getName());
            WishlistInfo wish = new WishlistInfo();
            wish.setGood(goodService.getById(goodId));
            wish.setUser(user);
            wishlist.add(wish);
            model.addAttribute("wishlist_db",wishlist.getByUser_id(user.getId()));
        }else {
            wishlist.addInWishlist(request.getSession(),goodService.getById(goodId));
        }

        return "ok";
    }

}
