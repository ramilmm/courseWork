package mvc.repositories;


import mvc.common.OrderGoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderGoodsRepositoryCustom extends JpaRepository<OrderGoodsInfo, Long> {

    List<OrderGoodsInfo> findBySorderId(Long orderId);

}
