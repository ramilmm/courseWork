package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.Log;
import mvc.common.GoodInfo;
import mvc.common.Sales;
import mvc.services.CatalogService;
import mvc.services.GoodService;
import mvc.services.SalesService;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SalesService salesService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage() {
        request.setAttribute("good_list", goodService.getAll());
        request.setAttribute("category_list", catalogService.getAllChildrens());
        return "admin/adminPage";
    }

    @Log
    @RequestMapping(value = "/sale/add", method = RequestMethod.POST)
    public String addSale(String Goods, Integer discount, String username) {
        if (discount > 99 || discount < 0) {
            return "redirect:/admin";
        }
        GoodInfo good = goodService.getByName(Goods);
        good.setDiscount((float) (1.0 - (discount/100.0)));
        goodService.update(good);
        Sales sale = new Sales();
        sale.setAdmin(userService.getByLogin(username));
        sale.setDiscount(discount);
        sale.setGood(good);
        salesService.add(sale);
        return "redirect:/admin";
    }

    @Log
    @RequestMapping(value = "/sale/addToCategory", method = RequestMethod.POST)
    public String addSaleToCategory(String Categories, Integer discount, String username) {
        if (discount > 99 || discount < 0) {
            return "redirect:/admin";
        }
        List<GoodInfo> goods = goodService.getByCategory(catalogService.getByName(Categories).getId());
        for (GoodInfo good : goods) {
            good.setDiscount((float) (1.0 - (discount/100.0)));
            goodService.update(good);
            Sales sale = new Sales();
            sale.setAdmin(userService.getByLogin(username));
            sale.setDiscount(discount);
            sale.setGood(good);
            salesService.add(sale);
        }
        return "redirect:/admin";
    }


}
