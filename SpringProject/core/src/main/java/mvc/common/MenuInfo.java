package mvc.common;

import java.util.List;


public class MenuInfo {

    /**
     * id пункта меню
     */
    private Long id;

    /**
     * Название пункта меню
     */
    private String name;

    /**
     * Список категорий для отображения
     */
    private List<CategoryInfo> listCategory;

    public MenuInfo() {
    }

    public MenuInfo(Long id, String name, List<CategoryInfo> listCategory) {
        this.id = id;
        this.name = name;
        this.listCategory = listCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryInfo> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<CategoryInfo> listCategory) {
        this.listCategory = listCategory;
    }
}
