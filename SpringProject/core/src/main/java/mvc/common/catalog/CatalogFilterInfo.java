package mvc.common.catalog;

import java.util.List;

public class CatalogFilterInfo {

    /**
     * Фильтры по категории
     */
    private List<FilterItem> categories;

    /**
     * Фильтры по цене
     */
    private List<PriceFilterItem> prices;

    /**
     * Фильтры по Автору
     */
    private List<FilterItem> authors;

    /**
     * Фильтры по веку издательства
     */
    private List<CenturyFilterItem> date;



    public CatalogFilterInfo() {
    }

    public CatalogFilterInfo(List<FilterItem> categories, List<PriceFilterItem> prices, List<FilterItem> authors, List<CenturyFilterItem> date) {
        this.categories = categories;
        this.prices = prices;
        this.authors = authors;
        this.date = date;
    }

    public List<FilterItem> getCategories() {
        return categories;
    }

    public void setCategories(List<FilterItem> categories) {
        this.categories = categories;
    }

    public List<FilterItem> getAuthors() {
        return authors;
    }

    public void setAuthors(List<FilterItem> authors) {
        this.authors = authors;
    }

    public List<CenturyFilterItem> getDate() {
        return date;
    }

    public void setDate(List<CenturyFilterItem> date) {
        this.date = date;
    }

    public List<PriceFilterItem> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceFilterItem> prices) {
        this.prices = prices;
    }
}
