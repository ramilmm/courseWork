package mvc.services;

import mvc.common.CategoryInfo;
import mvc.common.GoodInfo;
import mvc.repositories.CategoryRepositoryCustom;
import mvc.repositories.GoodRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
