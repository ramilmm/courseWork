package mvc.repositories;

import mvc.common.GoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

/*
* Access to database
* SQL query
* Using JPA
* */
public interface GoodRepositoryCustom extends JpaRepository<GoodInfo,Long> {

    GoodInfo findById(Long id);

    GoodInfo findByNameIgnoreCase(String name);

    List<GoodInfo> findByCategory_Id(Long id);

    List<GoodInfo> findByCountryIgnoreCase(String country);

    List<GoodInfo> findByAuthorIgnoreCase(String author);

    List<GoodInfo> findByCentury(Long century);

    List<GoodInfo> findByCostBetween(BigDecimal min_cost,BigDecimal max_cost);

    List<GoodInfo> findByStatusIgnoreCase(String status);

    List<GoodInfo> findByAuthorIgnoreCaseAndCentury(String author, Long century);

    List<GoodInfo> findByAuthorIgnoreCaseAndCostBetweenAndCentury(String author, BigDecimal min, BigDecimal max, Long century);

    List<GoodInfo> findByAuthorIgnoreCaseAndCostBetweenAndCenturyAndCountryIgnoreCase(String author,BigDecimal min, BigDecimal max, Long century,String country);

}
