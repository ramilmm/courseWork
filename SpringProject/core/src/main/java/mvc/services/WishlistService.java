//package mvc.services;
//
//
//import mvc.common.GoodInfo;
//import mvc.common.WishlistInfo;
//import mvc.common.WishlistUtil;
//import mvc.repositories.WishlistRepositoryCustom;
//import mvc.util.Constants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class WishlistService {
//
//    @Autowired
//    WishlistRepositoryCustom wishlist;
//
//    @Transactional
//    public void add(WishlistInfo wishlistInfo){
//        wishlist.saveAndFlush(wishlistInfo);
//    }
//
//    /**
//     * Добавление товара в wishlist
//     */
//    public void addInCart(HttpSession session, GoodInfo good) {
//        WishlistUtil wishlist = (WishlistUtil) session.getAttribute(Constants.SESSION_WISHLIST);
//
//        if (wishlist == null) {
//            wishlist = new WishlistUtil();
//        }
//        if (wishlist.getGoods() == null) {
//            List<GoodInfo> map = new ArrayList<GoodInfo>();
//            map.add(good);
//            wishlist.setGoods(map);
//        } else {
//                wishlist.getGoods().add(good);
//        }
//
//        session.setAttribute(Constants.SESSION_CART, wishlist);
//    }
//
//    @Transactional
//    public WishlistInfo getByUser_id(Long user_id){
//        return wishlist.findByUser_Id(user_id);
//    }
//
//    @Transactional
//    public WishlistInfo getByUser_login(String login){
//        return wishlist.findByUser_Login(login);
//    }
//
//}
