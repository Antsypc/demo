package xyz.antsgroup.demo.spring.transaction.entity;

/**
 * 物品分类表
 *
 * Created by Ants Young on 2016/7/17.
 */
public class Category {
    private int categoryId;
    private String name;
    private int parent;

    public Category() {
    }

    public Category(int categoryId, String name, int parent) {
        this.categoryId = categoryId;
        this.name = name;
        this.parent = parent;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
