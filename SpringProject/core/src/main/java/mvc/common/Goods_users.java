package mvc.common;

import javax.persistence.*;

@Entity
public class Goods_users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id")
    private GoodInfo goodInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UsersInfo usersInfo;

    public Goods_users() {}


    public Goods_users(GoodInfo goodInfo, UsersInfo usersInfo) {
        this.goodInfo = goodInfo;
        this.usersInfo = usersInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoodInfo getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(GoodInfo goodInfo) {
        this.goodInfo = goodInfo;
    }

    public UsersInfo getUsersInfo() {
        return usersInfo;
    }

    public void setUsersInfo(UsersInfo usersInfo) {
        this.usersInfo = usersInfo;
    }
}
