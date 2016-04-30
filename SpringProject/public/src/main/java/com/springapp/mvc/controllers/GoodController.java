package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import mvc.common.ReviewInfo;
import mvc.services.GoodService;
import mvc.services.MenuService;
import mvc.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/good")
public class GoodController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodService goodService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private MenuService menuService;

    private int from = 3;

    /**
     * Отображение карточки товара
     *
     * @param goodId id товара
     */
    @IncludeMenuInfo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderGoodPage(@PathVariable("id") Long goodId) {
        request.setAttribute("good", goodService.getById(goodId));
        List<ReviewInfo> comments = reviewService.getByGoodId(goodId);
        request.setAttribute("AllComments",comments);
        if(comments.size()>3){
            request.setAttribute("comments", comments.subList(0,from));
        }else{
            request.setAttribute("comments", comments);
        }
        return "good/goodPage";
    }

    /**
     * Обработка AJAX-запроса
     * @param id - id товара, для которого нужно подгружать комментарии
     */
    @RequestMapping(value = "/showMore", method = RequestMethod.POST)
    public String renderComments(Long id, Model model){
        List<ReviewInfo> allComments = reviewService.getByGoodId(id);
        List<ReviewInfo> newComments = new ArrayList<ReviewInfo>();
        if(allComments.size()>0){
            newComments = allComments.subList(from,allComments.size());
        }
        model.addAttribute("comments",newComments);
        return "good/ajaxComments";
    }

}
