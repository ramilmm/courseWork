package com.springapp.mvc.controllers;

import com.springapp.mvc.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(MyException.class)
    public String renderErrorPage(){
        return "errorPages/error-404";
    }
}
