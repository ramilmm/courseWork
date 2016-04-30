package mvc.services;

import mvc.common.GoodInfo;
import mvc.repositories.GoodRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GoodService {


//    @Autowired
//    private GoodRepository goodRepository;

    @Autowired
    private GoodRepositoryCustom goodRepositoryCustom;


    @Transactional
    public void add(GoodInfo goodInfo){
        goodRepositoryCustom.saveAndFlush(goodInfo);
    }

    @Transactional
    public void remove(Long id){
        goodRepositoryCustom.delete(getById(id));
    }

    @Transactional
    public void update(GoodInfo goodInfo) {
        goodRepositoryCustom.saveAndFlush(goodInfo);
    }

    @Transactional
    public GoodInfo getById(Long goodId) {
        return goodRepositoryCustom.findById(goodId);
    }

    @Transactional
    public GoodInfo getByName(String name){
        return goodRepositoryCustom.findByNameIgnoreCase(name);
    }

    @Transactional
    public List<GoodInfo> getByCategory(Long id){
        return goodRepositoryCustom.findByCategory_Id(id);
    }

    @Transactional
    public List<GoodInfo> getByCountry(String country){
        return goodRepositoryCustom.findByCountryIgnoreCase(country);
    }

    @Transactional
    public List<GoodInfo> getByAuthor(String author){
        return goodRepositoryCustom.findByAuthorIgnoreCase(author);
    }

    @Transactional
    public List<GoodInfo> getByCentury(Long century){
        return goodRepositoryCustom.findByCentury(century);
    }

    @Transactional
    public List<GoodInfo> getByCost(BigDecimal min, BigDecimal max){
        return goodRepositoryCustom.findByCostBetween(min,max);
    }

    @Transactional
    public List<GoodInfo> getByStatus(String status){
        return goodRepositoryCustom.findByStatusIgnoreCase(status);
    }

    /**
     * Получение товара по автору и веку издательства
     */
    @Transactional
    public List<GoodInfo> getByAuthorAndCentury(String author,Long century){
        return goodRepositoryCustom.findByAuthorIgnoreCaseAndCentury(author,century);
    }

    /**
     * Получение товара по автору,цене и веку издательства
     */
    @Transactional
    public List<GoodInfo> getByAuthorAndCostAndCentury(String author,BigDecimal min,BigDecimal max,Long century){
        return goodRepositoryCustom.findByAuthorIgnoreCaseAndCostBetweenAndCentury(author,min,max,century);
    }

    /**
     * Получение товара по автору, цене,веку и стране
     */
    @Transactional
    public List<GoodInfo> getByAuthorAncCostAndCenturyAndCountry(String author,BigDecimal min,BigDecimal max,Long century,String country){
        return goodRepositoryCustom.findByAuthorIgnoreCaseAndCostBetweenAndCenturyAndCountryIgnoreCase(author,min,max,century,country);
    }
}
