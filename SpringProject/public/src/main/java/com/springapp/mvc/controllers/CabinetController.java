package com.springapp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage() {
        return "cabinet/cabinetPage";
    }
}
