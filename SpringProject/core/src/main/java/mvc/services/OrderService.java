package mvc.services;

import mvc.common.OrdersInfo;
import mvc.repositories.OrdersRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepositoryCustom ordersRepositoryCustom;


    @Transactional
    public void add(OrdersInfo ordersInfo){
        ordersRepositoryCustom.saveAndFlush(ordersInfo);
    }

    public List<OrdersInfo> getById(Long id){
        return ordersRepositoryCustom.findById(id);
    }
}
