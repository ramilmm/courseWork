package mvc.common.catalog;

import java.math.BigDecimal;

/**
 * Фильтр по цене
 *
 * Gataullin Kamil
 * 28.02.2016 20:33
 */
public class PriceFilterItem {

    /**
     * Минимальная цена
     */
    private BigDecimal minPrice;

    /**
     * Максимальная цена
     */
    private BigDecimal maxPrice;

    /**
     * Кол-во товара
     */
    private Integer count;

    public PriceFilterItem() {
    }

    public PriceFilterItem(BigDecimal minPrice, BigDecimal maxPrice, Integer count) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.count = count;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
