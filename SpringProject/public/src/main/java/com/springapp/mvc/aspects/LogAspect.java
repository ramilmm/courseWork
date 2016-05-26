package com.springapp.mvc.aspects;

import com.springapp.mvc.form.FeedbackFormBean;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.form.ReviewFormBean;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    private final static Logger log = Logger.getLogger(LogAspect.class.getName());


    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.Log)")
    public void logMethod() { }

    @After("logMethod()")
    public void logMethod(JoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        Object[] methodArgs = point.getArgs();
        Class c;
        if(methodName.equals("registrationForm")) {
            c = methodArgs[0].getClass();
            RegistrationFormBean rfb = (RegistrationFormBean) methodArgs[0];
            Method getLogin = c.getMethod("getEmail");
            log.info("Register a new user " +
                    " with login : " + getLogin.invoke(rfb));
        }else if (methodName.equals("reviewForm")){
            c = methodArgs[0].getClass();
            Long goodId = (Long) methodArgs[2];
            ReviewFormBean review = (ReviewFormBean) methodArgs[0];
            Method getFirstName = c.getMethod("getFirstName");
            Method getEmail = c.getMethod("getEmail");
            log.info("User with firstname = " + getFirstName.invoke(review) +
                     " and email = " + getEmail.invoke(review) +
                     " write review to Book with id = " + goodId);
        }else if (methodName.equals("feedbackForm")){
            c = methodArgs[0].getClass();
            FeedbackFormBean feedback = (FeedbackFormBean) methodArgs[0];
            Method getFirstName = c.getMethod("getFirstName");
            Method getEmail = c.getMethod("getEmail");
            log.info("User with firstname = " + getFirstName.invoke(feedback) +
                    " and email = " + getEmail.invoke(feedback) +
                    " write feedback");
        }else if(methodName.equals("addSale") || methodName.equals("addSaleToCategory")){
            String good = (String) methodArgs[0];
            Integer discount = (Integer) methodArgs[1];
            String admin = (String) methodArgs[2];
            log.info("Admin " + admin + " add discount("+discount+"%) to " + good);
        }
    }
}
