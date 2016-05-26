package mvc.repositories;


import mvc.common.GoodInfo;
import mvc.common.Sales;
import mvc.common.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepositoryCustom extends JpaRepository<Sales, Long> {

    List<Sales> findById(Long id);

    List<Sales> findByAdmin(UsersInfo admin);

    Sales findByGood(GoodInfo good);

}
