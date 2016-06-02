package Services;

import mvc.common.CategoryInfo;
import mvc.common.GoodInfo;
import mvc.repositories.GoodRepositoryCustom;
import mvc.services.GoodService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GoodServiceTest {

    private static GoodService goodService;
    private static GoodInfo good;
    private static List<GoodInfo> goods;

    @BeforeClass
    public static void init(){
        goodService = new GoodService();
        goodService.goodRepositoryCustom = mock(GoodRepositoryCustom.class);
        System.out.println(goodService.goodRepositoryCustom);
        goods = new ArrayList<GoodInfo>();
        good = new GoodInfo("Book", new BigDecimal(51),new CategoryInfo(999L,"Category1",null),"BestSeller",19L,"pushkin","Russia",19L,"img1.jpg","descr");
        goods.add(mock(GoodInfo.class));
        goods.add(mock(GoodInfo.class));


        when(goodService.goodRepositoryCustom.findById(anyLong())).thenReturn(good);
        when(goodService.goodRepositoryCustom.findAll()).thenReturn(goods);
    }
    @Test
    public void getAllShouldReturnCorrectListOfGoods(){
        Assert.assertEquals(goodService.getAll(),goods);
    }

    @Test
    public void getByIdShouldReturnCorrectGood(){
        Assert.assertEquals(goodService.getById(2L),good);
    }

}
