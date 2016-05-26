package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.aspects.annotation.Log;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.mail.Sender;
import mvc.common.UsersInfo;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/reg")
public class RegistrationController {

    private static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;
    /**
     * Отображение страницы регистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        if(request.getRemoteUser() != null){
            return "redirect:/";
        }
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration/registrationPage";
    }

    /**
     * Обработка формы Регистрации
     * Отправка письма с ссылкой для подтверждения регистрации
     * Без подтвреждения регистрации пользователь не сможет авторизоваться
     */
    @Log
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean regBean,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "registration/registrationPage";
        }
        if (!regBean.getPassword().equals(regBean.getConfirmPassword())){
            model.addAttribute("error","Passwords don`t match");
            return "registration/registrationPage";
        }
        if(userService.getByLogin(regBean.getEmail()) != null){
            model.addAttribute("error","User with this email already exist");
            return "registration/registrationPage";
        }

        userService.add(new UsersInfo(regBean.getEmail(),md5Decoder(regBean.getPassword()),
                regBean.getEmail(),regBean.getFirstName()+" "+regBean.getLastName(),"ROLE_USER"));
        Long user_id = userService.getByLogin(regBean.getEmail()).getId();
        Sender sender = new Sender("bookstoreitis@gmail.com","parolparol");
        sender.send("REGISTRATION","Вы прошли успешную регистрацию на сайте bookStore\n" +
                "Для подтверждения регистрации пройдте по ссылке : http://localhost:8081/reg/activate?id="+ user_id + "\n" +
                "Ваш логин : "+regBean.getEmail(),"bookstoreitis@gmail.com",regBean.getEmail());

//        System.out.println(regBean);
        return "redirect:/";
    }

    /**
     * Обработка ссылки активации
     * @param id - id пользователя,достаётся из url
     */
    @RequestMapping(value = "/activate",method = RequestMethod.GET)
    public String activateUser(Long id){
        UsersInfo user=userService.getById(id);
        user.setActive(true);
        userService.update(user);
        return "redirect:/login";
    }

    /**
     * MD5 хэширование пароля
     */
    private String md5Decoder(String password){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(password.getBytes(),0, password.length());
        String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);
        if (hashedPass.length() < 32) {
            hashedPass = "0" + hashedPass;
        }
        return hashedPass;
    }
}
