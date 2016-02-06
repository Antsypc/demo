package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "consumables", schema = "", catalog = "labms")
public class ConsumablesEntity {
    private String consumablesId;
    private int categoryId;
    private int total;
    private String unit;

    public ConsumablesEntity() {
    }

    public ConsumablesEntity(String consumablesId, int categoryId, int total, String unit) {
        this.consumablesId = consumablesId;
        this.categoryId = categoryId;
        this.total = total;
        this.unit = unit;
    }

    @Id
    @Column(name = "consumablesId", nullable = false, insertable = true, updatable = true, length = 255)
    public String getConsumablesId() {
        return consumablesId;
    }

    public void setConsumablesId(String consumablesId) {
        this.consumablesId = consumablesId;
    }

    @Basic
    @Column(name = "categoryId", nullable = false, insertable = true, updatable = true)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "total", nullable = false, insertable = true, updatable = true)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Basic
    @Column(name = "unit", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumablesEntity that = (ConsumablesEntity) o;

        if (categoryId != that.categoryId) return false;
        if (total != that.total) return false;
        if (consumablesId != null ? !consumablesId.equals(that.consumablesId) : that.consumablesId != null)
            return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = consumablesId != null ? consumablesId.hashCode() : 0;
        result = 31 * result + categoryId;
        result = 31 * result + total;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
