package Entities;


import mvc.common.AddressInfo;
import mvc.common.OrdersInfo;
import mvc.common.UsersInfo;
import mvc.services.OrderService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderTest {

    private static OrdersInfo order;
    private static OrderService service;
    private static UsersInfo user;
    private static AddressInfo address;

    @BeforeClass
    public static void init(){
        user = new UsersInfo("ramilmmk@gmail.com","13523523twe","ramilmmk@gmail.com","Ramil","ROLE_ADMIN");
        address = new AddressInfo("Kazan","Baumana","32a",95L,"429334","Tatarstan",user);
        order = new OrdersInfo(user,address,new Date(),new BigDecimal(30),1L,"В обработке","Наложенный платёж");
        List<OrdersInfo> orders = new ArrayList<OrdersInfo>();
        orders.add(order);
        service = mock(OrderService.class);
        when(service.getByUser(any(UsersInfo.class))).thenReturn(orders);
    }

    @Test
    public void addressTest(){
        AddressInfo a = service.getByUser(new UsersInfo()).get(0).getAddress();
        Assert.assertEquals("Kazan",a.getCity());
    }

    @Test
    public void userTest(){
        UsersInfo a = service.getByUser(new UsersInfo()).get(0).getUser();
        Assert.assertEquals("ramilmmk@gmail.com",a.getEmail());
    }

    @Test
    public void orderCostTest(){
        OrdersInfo a = service.getByUser(new UsersInfo()).get(0);
        Assert.assertEquals(new BigDecimal(30),a.getTotal_sum());
    }

    @Test
    public void statusTest(){
        OrdersInfo a = service.getByUser(new UsersInfo()).get(0);
        Assert.assertEquals("В обработке",a.getStatus());
    }

    @Test
    public void payTypeTest(){
        OrdersInfo a = service.getByUser(new UsersInfo()).get(0);
        Assert.assertEquals("Наложенный платёж",a.getPay_type());
    }

}
