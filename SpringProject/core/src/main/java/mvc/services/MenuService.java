package mvc.services;

import mvc.common.CategoryInfo;
import mvc.repositories.CategoryRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuService {

    @Autowired
    private CategoryRepositoryCustom categoryRepositoryCustom;



    /**
     * Получаем основное меню сайта
     * findByParent_idIsNull - получает все дочерние категории для отображения в выпадающих списках
     */
    public List<CategoryInfo> getMainMenu() {
        return categoryRepositoryCustom.findByParent_IdIsNull();
    }


}

