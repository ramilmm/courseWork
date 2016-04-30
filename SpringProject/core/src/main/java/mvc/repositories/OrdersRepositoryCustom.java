package mvc.repositories;

import mvc.common.OrdersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrdersRepositoryCustom extends JpaRepository<OrdersInfo, Long> {

    List<OrdersInfo> findById(Long id);

}
