package mvc.common;

import javax.persistence.*;

@Entity
@Table(name = "Reviews")
public class ReviewInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "good_id")
    private GoodInfo good;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UsersInfo user;

    @Column(length = 2000)
    private String content;

    public ReviewInfo () {}

    public ReviewInfo(GoodInfo good_id, UsersInfo user_id, String content) {
        this.good = good_id;
        this.user = user_id;
        this.content = content;
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

    public UsersInfo getUser() {
        return user;
    }

    public void setUser(UsersInfo user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

