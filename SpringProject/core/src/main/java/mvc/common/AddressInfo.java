package mvc.common;


import javax.persistence.*;

@Entity
@Table(name = "Address")
public class AddressInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50)
    private String street;

    @Column(length = 25)
    private String house;

    @Column(length = 25)
    private String flat;

    @Column(length = 6)
    private String post_index;

    @Column(length = 50)
    private String area;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UsersInfo user;

    public AddressInfo () {}

    public AddressInfo(String city, String street, String house, String flat, String post_index, String area, UsersInfo user) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.post_index = post_index;
        this.area = area;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPost_index() {
        return post_index;
    }

    public void setPost_index(String post_index) {
        this.post_index = post_index;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public UsersInfo getUser() {
        return user;
    }

    public void setUser(UsersInfo user) {
        this.user = user;
    }
}

