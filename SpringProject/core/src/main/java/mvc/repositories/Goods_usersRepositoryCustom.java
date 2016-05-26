package mvc.repositories;


import mvc.common.Goods_users;
import mvc.common.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Goods_usersRepositoryCustom  extends JpaRepository<Goods_users, Long>{

    List<Goods_users> findById(Long id);

    List<Goods_users> findByUsersInfo(UsersInfo user);

}
