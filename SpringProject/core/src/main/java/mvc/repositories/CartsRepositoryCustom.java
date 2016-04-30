package mvc.repositories;

import mvc.common.Cart;
import mvc.common.GoodInfo;
import mvc.common.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CartsRepositoryCustom extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c where c.user_id = ?1")
    List<Cart> findByUser_id(UsersInfo user_id);

    @Query("select c from Cart c where c.user_id = ?1 and c.good_id = ?2")
    Cart findByUser_idAndGood_id(UsersInfo usersInfo, GoodInfo goodInfo);
}
