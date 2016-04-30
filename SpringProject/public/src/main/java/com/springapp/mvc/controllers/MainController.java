package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import mvc.common.GoodInfo;
import mvc.services.CatalogService;
import mvc.services.GoodService;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private UserService userService;

    /**
     * Отображение главной страницы сайта
     * подгрузка товаров для вкладок
     */
    @IncludeMenuInfo
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMain(ModelMap model) {
        List<GoodInfo> bestseller = catalogService.getByStatus("Bestseller");
        List<GoodInfo> newArrival = catalogService.getByStatus("New arrival");
        List<GoodInfo> usedBook = catalogService.getByStatus("Used book");
        List<GoodInfo> exclusive = catalogService.getByStatus("Exclusive");
        GoodInfo deal = goodService.getById(1L);
        model.addAttribute("bestSeller", bestseller);
        model.addAttribute("usedBook", usedBook);
        model.addAttribute("newArrival", newArrival);
        model.addAttribute("exclusive", exclusive);
        model.addAttribute("deal", deal);
        return "main/main";
    }
}
