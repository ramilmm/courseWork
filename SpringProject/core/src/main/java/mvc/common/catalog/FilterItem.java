package mvc.common.catalog;

public class FilterItem {

    /**
     * ID фильтра
     */
    private Long id;

    /**
     * Название
     */
    private String name;

    /**
     * Кол-во подходящих товаров
     */
    private Integer count;

    public FilterItem() {
    }

    public FilterItem(Long id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
