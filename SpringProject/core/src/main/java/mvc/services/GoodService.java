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



    @Autowired
    private GoodRepositoryCustom goodRepositoryCustom;

    public List<GoodInfo> getAll(){
        return goodRepositoryCustom.findAll();
    }


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

    public GoodInfo getById(Long goodId) {
        return goodRepositoryCustom.findById(goodId);
    }

    public GoodInfo getByName(String name){
        return goodRepositoryCustom.findByNameIgnoreCase(name);
    }

    public List<GoodInfo> getByCategory(Long id){
        return goodRepositoryCustom.findByCategory_Id(id);
    }

    public List<GoodInfo> getByCountry(String country){
        return goodRepositoryCustom.findByCountryIgnoreCase(country);
    }

    public List<GoodInfo> getByAuthor(String author){
        return goodRepositoryCustom.findByAuthorIgnoreCase(author);
    }

    public List<GoodInfo> getByCentury(Long century){
        return goodRepositoryCustom.findByCentury(century);
    }

    public List<GoodInfo> getByCost(BigDecimal min, BigDecimal max){
        return goodRepositoryCustom.findByCostBetween(min,max);
    }

    public List<GoodInfo> getTop5ByCategory(Long goodId){
        GoodInfo thisGood = goodRepositoryCustom.findById(goodId);
        List<GoodInfo> list = goodRepositoryCustom.findByCategory_IdOrderByRatingDesc(thisGood.getCategory().getId());
        if (list.size() == 1){
            list = goodRepositoryCustom.findByAuthorIgnoreCase(thisGood.getAuthor());
        }
        if (list.size() == 1){
            list = goodRepositoryCustom.findByCentury(thisGood.getCentury());
        }
        GoodInfo goodToRemove = null;
        for (GoodInfo good : list){
            if (good.getId().equals(goodId)){
                goodToRemove = good;
            }
        }
        if(goodToRemove!=null) {
            list.remove(goodToRemove);
        }
        if (list.size() > 5) {
            list.subList(0,5);
        }
        return list;
    }


    @Transactional
    public void popularUp(Long goodId){
        GoodInfo good = goodRepositoryCustom.findById(goodId);
        Long buf = good.getRating();
        good.setRating(++buf);
        goodRepositoryCustom.save(good);
    }

    public List<GoodInfo> getByStatus(String status){
        return goodRepositoryCustom.findByStatusIgnoreCase(status);
    }

    /**
     * Получение товара по автору и веку издательства
     */
    public List<GoodInfo> getByAuthorAndCentury(String author,Long century){
        return goodRepositoryCustom.findByAuthorIgnoreCaseAndCentury(author,century);
    }

    /**
     * Получение товара по автору,цене и веку издательства
     */
    public List<GoodInfo> getByAuthorAndCostAndCentury(String author,BigDecimal min,BigDecimal max,Long century){
        return goodRepositoryCustom.findByAuthorIgnoreCaseAndCostBetweenAndCentury(author,min,max,century);
    }

    /**
     * Получение товара по автору, цене,веку и стране
     */
    public List<GoodInfo> getByAuthorAncCostAndCenturyAndCountry(String author,BigDecimal min,BigDecimal max,Long century,String country){
        return goodRepositoryCustom.findByAuthorIgnoreCaseAndCostBetweenAndCenturyAndCountryIgnoreCase(author,min,max,century,country);
    }
}
