package mvc.repositories;

import mvc.common.OrdersInfo;
import mvc.common.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrdersRepositoryCustom extends JpaRepository<OrdersInfo, Long> {

    OrdersInfo findById(Long id);

    List<OrdersInfo> findByUser(UsersInfo user);

}
