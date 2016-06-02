package Entities;


import mvc.common.CategoryInfo;
import mvc.services.CatalogService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryTest {

    private static CatalogService catalogService;
    private static CategoryInfo child;
    private static CategoryInfo category;

    @BeforeClass
    public static void init(){
        child = new CategoryInfo(2L,"child",null);
        List<CategoryInfo> childs = new ArrayList<CategoryInfo>();
        childs.add(child);
        category = new CategoryInfo(1L,"category",childs);
        catalogService = mock(CatalogService.class);
        when(catalogService.getById(anyLong())).thenReturn(category);
    }

    @Test
    public void nameTest(){
        CategoryInfo cat = catalogService.getById(5L);
        Assert.assertEquals("category",cat.getName());
    }

    @Test
    public void childTest(){
        CategoryInfo cat = catalogService.getById(5L).getChildren().get(0);
        Assert.assertEquals(child.getId(),cat.getId());
    }

}
