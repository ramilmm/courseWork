package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.aspects.annotation.Log;
import com.springapp.mvc.form.FeedbackFormBean;
import mvc.common.Feedback;
import mvc.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    public static final String ATTR_FEEDBACK_FORM = "feedbackForm";


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FeedbackService feedback;

    /**
     * Отображение страницы с формой "Обратная связь"
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderFeedbackPage() {
        request.setAttribute(ATTR_FEEDBACK_FORM, new FeedbackFormBean());
        return "feedback/feedbackPage";
    }

    /**
     * Обработка формы обратной связи
     */
    @Log
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String feedbackForm(
            @Valid @ModelAttribute(ATTR_FEEDBACK_FORM) FeedbackFormBean feedbackFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "feedback/feedbackPage";
        }
        Feedback fb = new Feedback();
        fb.setFirstname(feedbackFormBean.getFirstName());
        fb.setSecondname(feedbackFormBean.getSecondName());
        fb.setEmail(feedbackFormBean.getEmail());
        fb.setSubject(feedbackFormBean.getSubject());

        feedback.add(fb);
//        System.out.println(feedbackFormBean);
        return "redirect:/";
    }
}
