package mvc.services;

import mvc.common.OrdersInfo;
import mvc.common.UsersInfo;
import mvc.repositories.OrdersRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepositoryCustom ordersRepositoryCustom;


    @Transactional
    public void add(OrdersInfo ordersInfo){
        ordersRepositoryCustom.saveAndFlush(ordersInfo);
    }

    @Transactional
    public void delete(OrdersInfo ordersInfo){
        ordersRepositoryCustom.delete(ordersInfo);
    }

    public List<OrdersInfo> getByUser(UsersInfo user){
        return ordersRepositoryCustom.findByUser(user);
    }

    public OrdersInfo getById(Long id){
        return ordersRepositoryCustom.findById(id);
    }

    public OrdersInfo getByCreationTime(Date date){
        return ordersRepositoryCustom.findByCreationTime(date);
    }
}
