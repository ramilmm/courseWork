package mvc.services;

import mvc.common.CartInfo;
import mvc.common.OrderGoodsInfo;
import mvc.repositories.OrderGoodsRepositoryCustom;
import mvc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderGoodsService {

    @Autowired
    private OrderGoodsRepositoryCustom repository;

    @Transactional
    public void add(Long orderId, HttpSession session){
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        Map<Long, Integer> goods = cart.getGoods();
        List<Long> order_goods = new ArrayList<Long>();
        for (Map.Entry map : goods.entrySet()){
            order_goods.add((Long) map.getKey());
        }
        for (Long goodId : order_goods){
            OrderGoodsInfo order = new OrderGoodsInfo(orderId,goodId);
            repository.saveAndFlush(order);
        }
    }

    @Transactional
    public void delete(Long orderId){
        List<OrderGoodsInfo> list = repository.findBySorderId(orderId);
        for (OrderGoodsInfo o_g : list){
            repository.delete(o_g);
        }
    }

}
