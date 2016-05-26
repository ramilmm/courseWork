package com.springapp.mvc.aspects;

import mvc.common.CategoryInfo;
import mvc.services.MenuService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
public class MainMenuAspect {

    private static final String MAIN_MENU_LIST = "Menu";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private MenuService menuService;

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeMenuInfo)")
    public void includeMenuInfoMethod() {
    }

    @Before("includeMenuInfoMethod()")
    public void includeMenuInfo() {
        List<CategoryInfo> listMenu = menuService.getMainMenu();
        request.setAttribute(MAIN_MENU_LIST, listMenu);
    }
}