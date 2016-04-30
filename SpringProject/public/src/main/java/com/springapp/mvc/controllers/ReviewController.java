package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.form.ReviewFormBean;
import mvc.services.GoodService;
import mvc.services.ReviewService;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/write-review")
public class ReviewController {

    private static final String ATTR_REVIEW_FORM = "reviewForm";


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private UserService userService;

    /**
     * Отображение страницы с формой "Review"
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderReviewPage(Long id) {
        request.setAttribute("good",goodService.getById(id));
        request.setAttribute(ATTR_REVIEW_FORM, new ReviewFormBean());
        return "review/reviewPage";
    }

    /**
     * Обработка формы REVIEW
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String reviewForm(
            @Valid @ModelAttribute(ATTR_REVIEW_FORM) ReviewFormBean reviewFormBean,
            BindingResult bindingResult,
            Long goodId){
        System.out.println(reviewFormBean);
        if (bindingResult.hasErrors()) {
            return "redirect:/write-review?id="+goodId;
        }
        reviewService.add(goodId,userService.getByLogin(request.getUserPrincipal().getName()).getId(),
                reviewFormBean.getReview(),reviewFormBean.getFirstName(),reviewFormBean.getEmail());


        System.out.println(reviewFormBean);
        return "redirect:/good/"+goodId;
    }

}
