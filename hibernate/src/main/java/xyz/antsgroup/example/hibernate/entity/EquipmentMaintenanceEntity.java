package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "equipmentMaintenance", schema = "", catalog = "labms")
public class EquipmentMaintenanceEntity {
    private int equipmentMaintenanceId;
    private String equipmentId;
    private String action;
    private int amount;
    private int checkInTime;
    private Integer returnTime;
    private String managerId;
    private String checkInDescription;
    private String returnDescription;

    @Id
    @Column(name = "equipmentMaintenanceId", nullable = false, insertable = true, updatable = true)
    public int getEquipmentMaintenanceId() {
        return equipmentMaintenanceId;
    }

    public void setEquipmentMaintenanceId(int equipmentMaintenanceId) {
        this.equipmentMaintenanceId = equipmentMaintenanceId;
    }

    @Basic
    @Column(name = "equipmentId", nullable = false, insertable = true, updatable = true, length = 255)
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
    @Column(name = "checkInTime", nullable = false, insertable = true, updatable = true)
    public int getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(int checkInTime) {
        this.checkInTime = checkInTime;
    }

    @Basic
    @Column(name = "returnTime", nullable = true, insertable = true, updatable = true)
    public Integer getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Integer returnTime) {
        this.returnTime = returnTime;
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
    @Column(name = "checkInDescription", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getCheckInDescription() {
        return checkInDescription;
    }

    public void setCheckInDescription(String checkInDescription) {
        this.checkInDescription = checkInDescription;
    }

    @Basic
    @Column(name = "returnDescription", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getReturnDescription() {
        return returnDescription;
    }

    public void setReturnDescription(String returnDescription) {
        this.returnDescription = returnDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentMaintenanceEntity that = (EquipmentMaintenanceEntity) o;

        if (equipmentMaintenanceId != that.equipmentMaintenanceId) return false;
        if (amount != that.amount) return false;
        if (checkInTime != that.checkInTime) return false;
        if (equipmentId != null ? !equipmentId.equals(that.equipmentId) : that.equipmentId != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (returnTime != null ? !returnTime.equals(that.returnTime) : that.returnTime != null) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (checkInDescription != null ? !checkInDescription.equals(that.checkInDescription) : that.checkInDescription != null)
            return false;
        if (returnDescription != null ? !returnDescription.equals(that.returnDescription) : that.returnDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentMaintenanceId;
        result = 31 * result + (equipmentId != null ? equipmentId.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + checkInTime;
        result = 31 * result + (returnTime != null ? returnTime.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (checkInDescription != null ? checkInDescription.hashCode() : 0);
        result = 31 * result + (returnDescription != null ? returnDescription.hashCode() : 0);
        return result;
    }
}
