package mvc.common;


//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Users")
public class UsersInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "hash_pass")
    private String hash_pass;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "profile_img")
    private String profile_img_url;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private Boolean active = false;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy="user")
    @Column(name = "check")
    private List<OrdersInfo> orders;



    public UsersInfo () {}


    public UsersInfo(String login, String hash_pass, String name, String role) {
        this.login = login;
        this.hash_pass = hash_pass;
        this.name = name;
        this.role = role;
    }

    public UsersInfo(String login, String hash_pass, String email, String name, String role) {
        this.login = login;
        this.hash_pass = hash_pass;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrdersInfo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersInfo> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash_pass() {
        return hash_pass;
    }

    public void setHash_pass(String hash_pass) {
        this.hash_pass = hash_pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_img_url() {
        return profile_img_url;
    }

    public void setProfile_img_url(String profile_img_url) {
        this.profile_img_url = profile_img_url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
