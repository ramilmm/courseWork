package mvc.services;

import mvc.common.Cart;
import mvc.common.CartInfo;
import mvc.common.UsersInfo;
import mvc.repositories.CartsRepositoryCustom;
import mvc.repositories.GoodRepositoryCustom;
import mvc.repositories.UserRepositoryCustom;
import mvc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CartService {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;
    @Autowired
    private CartsRepositoryCustom cartRepository;
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

    @Transactional
    public void addInCart(Long userId,Long goodId, Long count){
            cartRepository.saveAndFlush(new Cart(userRepositoryCustom.findById(userId),goodRepositoryCustom.findById(goodId),count));
    }

    public List<Cart> getByUser(UsersInfo user){
        return cartRepository.findByUser_id(user);
    }

    @Transactional
    public void update(Cart cart){
        cartRepository.save(cart);
    }

    @Transactional
    public void addInCart(Cart cart){
        cartRepository.saveAndFlush(cart);
    }

    @Transactional
    public void delete(Long user_id, Long good_id){
        cartRepository.delete(cartRepository.findByUser_idAndGood_id(userRepositoryCustom.findById(user_id),goodRepositoryCustom.findById(good_id)));
    }

}
