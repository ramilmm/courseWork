package com.springapp.mvc.controllers;


import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import mvc.common.CategoryInfo;
import mvc.common.GoodInfo;
import mvc.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    /**
     * Отображение каталога
     *
     * @param id    id категории
     * @return отображение каталога
     */
    @IncludeMenuInfo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderCatalog(@PathVariable("id") Long id,
                                Model model) {
        List<GoodInfo> goods = catalogService.getGoodsByCategoryId(id);
        model.addAttribute("goods", goods);

        CategoryInfo categoryInfo = catalogService.getById(id);
        model.addAttribute("category",categoryInfo);

//        List<CategoryInfo> menu = menuService.getMainMenu();
//        model.addAttribute("Menu",menu);
        return "catalog/catalogPage";
    }


    /**
     * Отображение главной страницы каталога
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String mainCatalog(HttpServletRequest request) {
        request.setAttribute("message", "Главная страница каталога");
        return "catalog/catalogPage";
    }
}
