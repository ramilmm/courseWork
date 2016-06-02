package mvc.common;

import javax.persistence.*;

@Entity
public class OrderGoodsInfo {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long sorderId;

    private Long goodId;

    public OrderGoodsInfo(){}


    public OrderGoodsInfo(Long sorderId, Long goodId) {
        this.sorderId = sorderId;
        this.goodId = goodId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSorderId() {
        return sorderId;
    }

    public void setSorderId(Long order_id) {
        this.sorderId = order_id;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long good_id) {
        this.goodId = good_id;
    }
}
