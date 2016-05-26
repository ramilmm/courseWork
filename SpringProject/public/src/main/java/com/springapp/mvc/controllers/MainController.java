package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.aspects.annotation.Log;
import mvc.common.GoodInfo;
import mvc.common.UsersInfo;
import mvc.services.CatalogService;
import mvc.services.GoodService;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    /**
     * Отображение главной страницы сайта
     * подгрузка товаров для вкладок
     */
    @Log
    @IncludeMenuInfo
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMain(ModelMap model) {
        List<GoodInfo> bestseller = catalogService.getByStatus("Bestseller");
        List<GoodInfo> newArrival = catalogService.getByStatus("New arrival");
        List<GoodInfo> usedBook = catalogService.getByStatus("Used book");
        List<GoodInfo> exclusive = catalogService.getByStatus("Exclusive");
        for (GoodInfo g : bestseller){
            if (g.getCount() == 0){
                bestseller.remove(g);
            }
        }
        for (GoodInfo g : newArrival){
            if (g.getCount() == 0){
                newArrival.remove(g);
            }
        }
        for (GoodInfo g : usedBook){
            if (g.getCount() == 0){
                usedBook.remove(g);
            }
        }
        for (GoodInfo g : exclusive){
            if (g.getCount() == 0){
                exclusive.remove(g);
            }
        }
        GoodInfo deal = goodService.getById(1L);
        if (request.getRemoteUser() != null){
            UsersInfo user = userService.getByLogin(request.getUserPrincipal().getName());
            List<GoodInfo> recommendations = userService.getRecomendations(user.getId());
            request.setAttribute("recommendations",recommendations);
        }
        model.addAttribute("bestSeller", bestseller);
        model.addAttribute("usedBook", usedBook);
        model.addAttribute("newArrival", newArrival);
        model.addAttribute("exclusive", exclusive);
        model.addAttribute("deal", deal);
        return "main/main";
    }
}
