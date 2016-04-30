package mvc.repositories;

import mvc.common.WishlistInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WishlistRepositoryCustom extends JpaRepository<WishlistInfo, Long> {

    WishlistInfo findByUser_Id(Long user_id);

    WishlistInfo findByUser_Login(String login);

}
