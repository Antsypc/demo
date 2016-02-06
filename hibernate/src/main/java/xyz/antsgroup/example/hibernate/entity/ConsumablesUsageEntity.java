package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "consumablesUsage", schema = "", catalog = "labms")
public class ConsumablesUsageEntity {
    private int consumablesUsageId;
    private String consumablesId;
    private String action;
    private int amount;
    private String managerId;
    private int time;
    private String description;

    @Id
    @Column(name = "consumablesUsageId", nullable = false, insertable = true, updatable = true)
    public int getConsumablesUsageId() {
        return consumablesUsageId;
    }

    public void setConsumablesUsageId(int consumablesUsageId) {
        this.consumablesUsageId = consumablesUsageId;
    }

    @Basic
    @Column(name = "consumablesId", nullable = false, insertable = true, updatable = true, length = 256)
    public String getConsumablesId() {
        return consumablesId;
    }

    public void setConsumablesId(String consumablesId) {
        this.consumablesId = consumablesId;
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
    @Column(name = "managerId", nullable = false, insertable = true, updatable = true, length = 8)
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumablesUsageEntity that = (ConsumablesUsageEntity) o;

        if (consumablesUsageId != that.consumablesUsageId) return false;
        if (amount != that.amount) return false;
        if (time != that.time) return false;
        if (consumablesId != null ? !consumablesId.equals(that.consumablesId) : that.consumablesId != null)
            return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = consumablesUsageId;
        result = 31 * result + (consumablesId != null ? consumablesId.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + time;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
