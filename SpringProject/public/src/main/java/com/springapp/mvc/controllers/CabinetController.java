package com.springapp.mvc.controllers;

import mvc.common.OrdersInfo;
import mvc.common.UsersInfo;
import mvc.services.OrderService;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage() {
        UsersInfo user = userService.getByLogin(request.getUserPrincipal().getName());
        request.setAttribute("orders",orderService.getByUser(user));
        return "cabinet/cabinetPage";
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.POST)
    public String deleteOrder(Long orderId){
        OrdersInfo order = orderService.getById(orderId);
        orderService.delete(order);
        return "cabinet/ajaxOrder";
    }
}
