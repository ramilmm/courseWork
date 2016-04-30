package mvc.common;

import javax.persistence.*;


@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UsersInfo user_id;

    @OneToOne
    @JoinColumn(name = "good_id")
    private GoodInfo good_id;

    @Column(name = "count")
    private Long count;

    public Cart() {
    }

    public Cart(UsersInfo user_id, GoodInfo good_id, Long count) {
        this.user_id = user_id;
        this.good_id = good_id;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersInfo getUser_id() {
        return user_id;
    }

    public void setUser_id(UsersInfo user_id) {
        this.user_id = user_id;
    }

    public GoodInfo getGood_id() {
        return good_id;
    }

    public void setGood_id(GoodInfo good_id) {
        this.good_id = good_id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
