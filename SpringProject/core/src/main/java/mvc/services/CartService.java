package mvc.services;

import mvc.common.CartInfo;
import mvc.repositories.GoodRepositoryCustom;
import mvc.repositories.UserRepositoryCustom;
import mvc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Service
public class CartService {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;
    @Autowired
    private GoodRepositoryCustom goodRepositoryCustom;


    /**
     * Добавление товара в корзину
     */
    public void addInCart(HttpSession session, Long goodId, Integer count) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart == null) {
            cart = new CartInfo();
        }
        if (cart.getGoods() == null) {
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            map.put(goodId, count);
            cart.setGoods(map);
        } else {
            if (cart.getGoods().containsKey(goodId)) {
                cart.getGoods().put(goodId, cart.getGoods().get(goodId) + count);
            } else {
                cart.getGoods().put(goodId, count);
            }
        }

        session.setAttribute(Constants.SESSION_CART, cart);
    }


}
