import mvc.common.CategoryInfo;
import mvc.common.GoodInfo;
import mvc.services.GoodService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GoodTest {

    GoodService goodService;

    @Before
    public void setUp(){
        GoodInfo good = new GoodInfo("Book", new BigDecimal(51),new CategoryInfo(999L,"Category1",null),"BestSeller",19L,"pushkin","Russia",19L,"img1.jpg","descr");
        goodService = mock(GoodService.class);
        when(goodService.getByName("Book")).thenReturn(good);
    }

    @Test
    public void costTest(){
        GoodInfo good = goodService.getByName("Book");
        Assert.assertNotEquals(new BigDecimal(56),good.getCost());
    }

    @Test
    public void statusTest(){
        GoodInfo good = goodService.getByName("Book");
        Assert.assertEquals("BestSeller",good.getStatus());
    }

    @Test
    public void centuryTest(){
        GoodInfo good = goodService.getByName("Book");
        Assert.assertEquals(new Long(19), good.getCentury());
    }

    @Test
    public void authorTest(){
        GoodInfo good = goodService.getByName("Book");
        Assert.assertEquals("pushkin",good.getAuthor());
    }
}
