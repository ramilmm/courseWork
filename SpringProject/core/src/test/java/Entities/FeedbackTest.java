package Entities;


import mvc.common.Feedback;
import mvc.services.FeedbackService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FeedbackTest {

    private static FeedbackService service;
    private static Feedback feedback;

    @BeforeClass
    public static void init(){
        feedback = new Feedback("Ramil","Makhmutov","email@mail.ru","lalalalla");
        service = mock(FeedbackService.class);
        when(service.getById(anyLong())).thenReturn(feedback);
    }

    @Test
    public void fnameTest(){
        Feedback f = service.getById(2L);
        Assert.assertEquals("Ramil",f.getFirstname());
    }

    @Test
    public void snameTest(){
        Feedback f = service.getById(2L);
        Assert.assertEquals("Makhmutov",f.getSecondname());
    }

    @Test
    public void emailTest(){
        Feedback f = service.getById(2L);
        Assert.assertEquals("email@mail.ru",f.getEmail());
    }

}
