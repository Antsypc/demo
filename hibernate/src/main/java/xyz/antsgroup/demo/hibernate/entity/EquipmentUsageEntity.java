package xyz.antsgroup.demo.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "equipmentUsage", schema = "", catalog = "labms")
public class EquipmentUsageEntity {
    private int equipmentUsageId;
    private String equipmentId;
    private String action;
    private int amount;
    private int time;

    @Id
    @Column(name = "equipmentUsageId", nullable = false, insertable = true, updatable = true)
    public int getEquipmentUsageId() {
        return equipmentUsageId;
    }

    public void setEquipmentUsageId(int equipmentUsageId) {
        this.equipmentUsageId = equipmentUsageId;
    }

    @Basic
    @Column(name = "equipmentId", nullable = false, insertable = true, updatable = true, length = 256)
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "action", nullable = false, insertable = true, updatable = true, length = 1)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "amount", nullable = false, insertable = true, updatable = true)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentUsageEntity that = (EquipmentUsageEntity) o;

        if (equipmentUsageId != that.equipmentUsageId) return false;
        if (amount != that.amount) return false;
        if (time != that.time) return false;
        if (equipmentId != null ? !equipmentId.equals(that.equipmentId) : that.equipmentId != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentUsageId;
        result = 31 * result + (equipmentId != null ? equipmentId.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + time;
        return result;
    }
}
