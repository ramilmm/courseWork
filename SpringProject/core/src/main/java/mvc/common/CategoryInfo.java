package mvc.common;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories")
public class CategoryInfo {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Category name
     */
    private String name;

    /**
     * list of category`s children
     */
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "parent")
    private List<CategoryInfo> children;

    /**
     * parent category
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryInfo parent;

    public CategoryInfo() {
    }

    public CategoryInfo(Long id, String name, List<CategoryInfo> children) {
        this.id = id;
        this.name = name;
        this.children = children;
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

    public List<CategoryInfo> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryInfo> children) {
        this.children = children;
    }

    public CategoryInfo getParent() {
        return parent;
    }

    public void setParent(CategoryInfo parent) {
        this.parent = parent;
    }
}