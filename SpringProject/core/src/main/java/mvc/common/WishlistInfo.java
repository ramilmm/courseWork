package mvc.common;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "wishlist")
public class WishlistInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UsersInfo user;

    @OneToOne
    @JoinColumn(name = "good_id")
    private GoodInfo good;

    public WishlistInfo(){}

    public WishlistInfo(UsersInfo user, GoodInfo good) {
        this.user = user;
        this.good = good;
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

    public GoodInfo getGood() {
        return good;
    }

    public void setGood(GoodInfo good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "WishlistInfo{" +
                "id=" + id +
                ", user=" + user +
                ", good=" + good +
                '}';
    }
}
