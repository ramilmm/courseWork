package mvc.common;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Good")
public class GoodInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(name = "Cost")
    private BigDecimal cost;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryInfo category;

    @Column(length = 50)
    private String status;

    @Column
    private Long century;

    @Column(length = 100)
    private String author;

    @Column(length = 50)
    private String country;

    @Column
    private Long count;

    @Column(length = 500)
    private String image;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String interesting_facts;

    @Column(name = "rating")
    private Long rating;

    public GoodInfo() {
    }



    public GoodInfo(String name, BigDecimal cost, CategoryInfo category, String status, Long century, String author, String country, Long count, String image, String description) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.status = status;
        this.century = century;
        this.author = author;
        this.country = country;
        this.count = count;
        this.image = image;
        this.description = description;
    }

    public GoodInfo(String name, BigDecimal cost, CategoryInfo category, String status, Long century, String author, String country, Long count, String image, String description, String interesting_facts) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.status = status;
        this.century = century;
        this.author = author;
        this.country = country;
        this.count = count;
        this.image = image;
        this.description = description;
        this.interesting_facts = interesting_facts;
    }

    public GoodInfo(String name, BigDecimal cost, CategoryInfo category, String status, Long century, String author, String country, Long count, String image, String description, String interesting_facts, Long rating) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.status = status;
        this.century = century;
        this.author = author;
        this.country = country;
        this.count = count;
        this.image = image;
        this.description = description;
        this.interesting_facts = interesting_facts;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public CategoryInfo getCategory() {
        return category;
    }

    public void setCategory(CategoryInfo category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCentury() {
        return century;
    }

    public void setCentury(Long century) {
        this.century = century;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInteresting_facts() {
        return interesting_facts;
    }

    public void setInteresting_facts(String interesting_facts) {
        this.interesting_facts = interesting_facts;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}