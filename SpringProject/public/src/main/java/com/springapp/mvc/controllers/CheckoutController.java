package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.form.CheckoutFormBean;
import mvc.common.AddressInfo;
import mvc.common.OrdersInfo;
import mvc.common.UsersInfo;
import mvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;

@Controller

public class CheckoutController {

    public static final String ATTR_CHECKOUT_FORM = "checkForm";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderGoodsService service;

    private Long qty;
    private BigDecimal sum;

    @IncludeMenuInfo

    @RequestMapping(value = "/cart/checkout",method = RequestMethod.GET)
    public String renderCheckoutPage() {
        request.setAttribute(ATTR_CHECKOUT_FORM, new CheckoutFormBean());
        return "cart/checkout";
    }

    @RequestMapping(value = "/cart/interval",method = RequestMethod.POST)
    public String intervalMethod(String total_quantity,
                                 String total_sum){
        qty = Long.parseLong(total_quantity);
        sum = new BigDecimal(Integer.parseInt(total_sum));
        UsersInfo user;
        if (request.getRemoteUser() != null) {
            user = userService.getByLogin(request.getUserPrincipal().getName());
        }else return "redirect:/login";
        AddressInfo address = addressService.getByUserId(user.getId());
        if (address != null ){
            OrdersInfo order = new OrdersInfo();
            order.setAddress(address);
            order.setUser(user);
            Date curDate = new Date();
            order.setCreationTime(curDate);
            order.setTotal_sum(sum);
            order.setTotal_count(qty);
            order.setStatus("Обработка");
            order.setPay_type("Наложеный платёж");
            orderService.add(order);
            service.add(orderService.getByCreationTime(curDate).getId(),request.getSession());
            return "redirect:/";
        }
        return "redirect:/cart/checkout";
    }
    /**
     * Добавление новой записи в таблицу Address
     */
    @IncludeMenuInfo
    @RequestMapping(value = "/cart/checkout",method = RequestMethod.POST)
    public String CheckoutForm(
            @Valid @ModelAttribute(ATTR_CHECKOUT_FORM) CheckoutFormBean checkoutFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cart/checkout";
        }

        UsersInfo user = userService.getByLogin(request.getUserPrincipal().getName());

        AddressInfo address = new AddressInfo(checkoutFormBean.getCity(), checkoutFormBean.getStreet(),
                checkoutFormBean.getHouse(), checkoutFormBean.getFlat(), checkoutFormBean.getPost_index(),
                checkoutFormBean.getArea(), user);
        addressService.add(address);
        orderService.add(new OrdersInfo(user,address,new Date(), sum, qty,"Обработка","Наложенный платёж"));
        return "redirect:/";
    }


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String OrderForm(){
        return "redirect:/";
    }
}
