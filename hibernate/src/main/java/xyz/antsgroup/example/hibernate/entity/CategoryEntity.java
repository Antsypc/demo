package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "category", schema = "", catalog = "labms")
public class CategoryEntity {
    private int categoryId;
    private String name;
    private Integer parent;

    @Id
    @Column(name = "categoryId", nullable = false, insertable = true, updatable = true)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parent", nullable = true, insertable = true, updatable = true)
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (categoryId != that.categoryId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}
