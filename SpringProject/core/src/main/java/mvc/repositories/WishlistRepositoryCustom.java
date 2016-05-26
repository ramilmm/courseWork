package mvc.repositories;

import mvc.common.WishlistInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WishlistRepositoryCustom extends JpaRepository<WishlistInfo, Long> {

    List<WishlistInfo> findByUser_Id(Long user_id);

    List<WishlistInfo> findByUser_Login(String login);

}
