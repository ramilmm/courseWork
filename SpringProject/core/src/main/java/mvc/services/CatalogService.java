package mvc.services;

import mvc.common.CategoryInfo;
import mvc.common.GoodInfo;
import mvc.repositories.CategoryRepositoryCustom;
import mvc.repositories.GoodRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogService {

    @Autowired
    private CategoryRepositoryCustom categoryRepositoryCustom;

    @Autowired
    private GoodRepositoryCustom goodRepositoryCustom;

    /**
     * Получение товаров по id категории
     *
     * @param categoryId id категории
     * @return список товаров
     */
    public List<GoodInfo> getGoodsByCategoryId(Long categoryId) {
        return goodRepositoryCustom.findByCategory_Id(categoryId);
    }

    public CategoryInfo getById(Long categoryId) {
        return categoryRepositoryCustom.findById(categoryId);
    }

    public CategoryInfo getByName(String categoryName) {
        return categoryRepositoryCustom.findByName(categoryName);
    }

    /**
     * Получаем товары для главной во вкладки Bestseller,new arrivals,used books,exclusive
     */
    public List<GoodInfo> getByStatus(String status) {
        return goodRepositoryCustom.findByStatusIgnoreCase(status);
    }

    public List<CategoryInfo> getAllChildrens() {
        return categoryRepositoryCustom.findByParent_IdIsNotNull();
    }


    public List<GoodInfo> filter(String authors, String country, String maxCost, String minCost){
        List<GoodInfo> result = new ArrayList<GoodInfo>();
        if(authors.isEmpty() && country.isEmpty()){
            result = goodRepositoryCustom.findByCostBetween(new BigDecimal(minCost),new BigDecimal(maxCost));
        }
        String[] author = authors.split(";");
        String[] countr = country.split(";");
        Integer max = Integer.parseInt(maxCost);
        Integer min = Integer.parseInt(minCost);
        List<GoodInfo> byAuthor = new ArrayList<GoodInfo>();
        List<GoodInfo> byCountry = new ArrayList<GoodInfo>();



        if(!authors.isEmpty()) {
            for (String anAuthor : author) {
                List<GoodInfo> buf = goodRepositoryCustom.findByCostBetweenAndAuthor(new BigDecimal(min), new BigDecimal(max), anAuthor);
                for (GoodInfo good : buf) {
                    if (!byAuthor.contains(good)) {
                        byAuthor.add(good);
                    }
                }
            }
            result = byAuthor;
        }
        if (authors.isEmpty() && !country.isEmpty()){
            for (String aCountr : countr) {
                List<GoodInfo> buf = goodRepositoryCustom.findByCostBetweenAndCountry(new BigDecimal(min), new BigDecimal(max), aCountr);
                for (GoodInfo good : buf) {
                    if (!byCountry.contains(good)) {
                        byCountry.add(good);
                    }
                }
            }
            result = byCountry;
        }

        if(!country.isEmpty()) {

            for (String aCountr : countr) {
                for (GoodInfo good : byAuthor) {
                    if (good.getCountry().equals(aCountr)) {
                        result.add(good);
                    }
                }
            }
        }
        return result;
    }

}
