package mvc.common.catalog;

/**
 * Created by Горендьже on 28.03.2016.
 */
public class CenturyFilterItem {
    /**
     * Минимальная date
     */
    private Long minDate;

    /**
     * Максимальная date
     */
    private Long maxDate;

    /**
     * Кол-во товара
     */
    private Integer count;

    public CenturyFilterItem() {}

    public CenturyFilterItem(Long minDate, Long maxDate, Integer count) {
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.count = count;
    }

    public Long getMinDate() {
        return minDate;
    }

    public void setMinDate(Long minDate) {
        this.minDate = minDate;
    }

    public Long getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Long maxDate) {
        this.maxDate = maxDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
