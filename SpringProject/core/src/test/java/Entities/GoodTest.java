package Entities;

import mvc.common.CategoryInfo;
import mvc.common.GoodInfo;
import mvc.services.GoodService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GoodTest {

    private static GoodService goodService;

    @BeforeClass
    public static void init(){
        GoodInfo good = new GoodInfo("Book", new BigDecimal(51),new CategoryInfo(999L,"Category1",null),"BestSeller",19L,"pushkin","Russia",19L,"img1.jpg","descr");
        goodService = mock(GoodService.class);
        when(goodService.getByName(anyString())).thenReturn(good);
    }

    @Test
    public void costTest(){
        GoodInfo good = goodService.getByName("Book");
        Assert.assertNotEquals(new BigDecimal(56),good.getCost());
    }

    @Test
    public void statusTest(){
        GoodInfo good = goodService.getByName("ASDs");
        Assert.assertEquals("BestSeller",good.getStatus());
    }

    @Test
    public void centuryTest(){
        GoodInfo good = goodService.getByName("BoASDAS");
        Assert.assertEquals(new Long(19), good.getCentury());
    }

    @Test
    public void authorTest(){
        GoodInfo good = goodService.getByName("Book");
        Assert.assertEquals("pushkin",good.getAuthor());
    }
}
