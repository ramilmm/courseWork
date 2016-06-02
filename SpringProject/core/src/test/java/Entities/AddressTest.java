package Entities;


import mvc.common.AddressInfo;
import mvc.common.UsersInfo;
import mvc.services.AddressService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressTest {

    private static AddressService service;
    protected static AddressInfo address;
    private static UsersInfo user;

    @BeforeClass
    public static void init(){
        user = new UsersInfo("ramilmmk@gmail.com","13523523twe","ramilmmk@gmail.com","Ramil","ROLE_ADMIN");
        address = new AddressInfo("Kazan","Baumana","32a",95L,"429334","Tatarstan",user);
        service = mock(AddressService.class);
        when(service.getById(anyLong())).thenReturn(address);
    }

    @Test
    public void testUser(){
        AddressInfo address = service.getById(23L);
        Assert.assertEquals(address.getUser().getId(),user.getId());
    }

    @Test
    public void testCity(){
        AddressInfo address = service.getById(23L);
        Assert.assertEquals("Kazan",address.getCity());
    }

    @Test
    public void testHouse(){
        AddressInfo address = service.getById(23L);
        Assert.assertEquals("32a",address.getHouse());
    }

    @Test
    public void testPostIndex(){
        AddressInfo address = service.getById(23L);
        Assert.assertEquals("429334",address.getPost_index());
    }

    @Test
    public void testArea(){
        AddressInfo address = service.getById(23L);
        Assert.assertEquals("Tatarstan",address.getArea());
    }
}
