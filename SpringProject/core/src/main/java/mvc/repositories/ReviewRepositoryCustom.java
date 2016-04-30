package mvc.repositories;

import mvc.common.ReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
* Acces to database
* SQL query
* Using JPA
* */
public interface ReviewRepositoryCustom extends JpaRepository<ReviewInfo, Long> {

    ReviewInfo findById(Long id);

    List<ReviewInfo> findByGood_Id(Long id);

    List<ReviewInfo> findByUser_Id(Long id);
}
