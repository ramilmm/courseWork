package mvc.common;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class OrdersInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UsersInfo user;

    @ManyToOne(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressInfo address;

    @Column
    private Date creation_time;

    @Column
    private BigDecimal Total_sum;

    @Column
    private Long Total_count;

    @Column
    private String status;

    @Column
    private String pay_type;

    public OrdersInfo() {}

    public OrdersInfo(UsersInfo user, AddressInfo address, Date creation_time, BigDecimal total_sum, Long total_count, String status, String pay_type) {
        this.user = user;
        this.address = address;
        this.creation_time = creation_time;
        this.Total_sum = total_sum;
        this.Total_count = total_count;
        this.status = status;
        this.pay_type = pay_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersInfo getUser() {
        return user;
    }

    public void setUser(UsersInfo user) {
        this.user = user;
    }

    public AddressInfo getAddress() {
        return address;
    }

    public void setAddress(AddressInfo address) {
        this.address = address;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public BigDecimal getTotal_sum() {
        return Total_sum;
    }

    public void setTotal_sum(BigDecimal total_sum) {
        Total_sum = total_sum;
    }

    public Long getTotal_count() {
        return Total_count;
    }

    public void setTotal_count(Long total_count) {
        Total_count = total_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }
}
