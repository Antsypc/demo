package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "equipment", schema = "", catalog = "labms")
public class EquipmentEntity {
    private String equipmentId;
    private int categoryId;
    private Integer total;
    private String unit;
    private int free;
    private byte isOk;

    @Id
    @Column(name = "equipmentId", nullable = false, insertable = true, updatable = true, length = 255)
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
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
    @Column(name = "total", nullable = true, insertable = true, updatable = true)
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
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

    @Basic
    @Column(name = "free", nullable = false, insertable = true, updatable = true)
    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    @Basic
    @Column(name = "isOk", nullable = false, insertable = true, updatable = true)
    public byte getIsOk() {
        return isOk;
    }

    public void setIsOk(byte isOk) {
        this.isOk = isOk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentEntity that = (EquipmentEntity) o;

        if (categoryId != that.categoryId) return false;
        if (free != that.free) return false;
        if (isOk != that.isOk) return false;
        if (equipmentId != null ? !equipmentId.equals(that.equipmentId) : that.equipmentId != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentId != null ? equipmentId.hashCode() : 0;
        result = 31 * result + categoryId;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + free;
        result = 31 * result + (int) isOk;
        return result;
    }
}
