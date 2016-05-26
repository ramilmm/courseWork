package mvc.common;

import javax.persistence.*;

@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "good_id")
    private GoodInfo good;

    private Integer discount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersInfo admin;

    public Sales () {}

    public Sales(GoodInfo good, Integer discount, UsersInfo admin) {
        this.good = good;
        this.discount = discount;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoodInfo getGood() {
        return good;
    }

    public void setGood(GoodInfo good) {
        this.good = good;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public UsersInfo getAdmin() {
        return admin;
    }

    public void setAdmin(UsersInfo admin) {
        this.admin = admin;
    }
}
