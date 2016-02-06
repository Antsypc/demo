package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "labRoom", schema = "", catalog = "labms")
public class LabRoomEntity {
    private String labRoomId;
    private String campus;
    private String building;
    private String roomName;
    private String roomType;
    private short capacity;
    private String managerId;
    private String managerName;

    @Id
    @Column(name = "labRoomId", nullable = false, insertable = true, updatable = true, length = 7)
    public String getLabRoomId() {
        return labRoomId;
    }

    public void setLabRoomId(String labRoomId) {
        this.labRoomId = labRoomId;
    }

    @Basic
    @Column(name = "campus", nullable = false, insertable = true, updatable = true, length = 15)
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Basic
    @Column(name = "building", nullable = false, insertable = true, updatable = true, length = 30)
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "roomName", nullable = false, insertable = true, updatable = true, length = 30)
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Basic
    @Column(name = "roomType", nullable = true, insertable = true, updatable = true, length = 30)
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Basic
    @Column(name = "capacity", nullable = false, insertable = true, updatable = true)
    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "managerId", nullable = true, insertable = true, updatable = true, length = 8)
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "managerName", nullable = true, insertable = true, updatable = true, length = 20)
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabRoomEntity that = (LabRoomEntity) o;

        if (capacity != that.capacity) return false;
        if (labRoomId != null ? !labRoomId.equals(that.labRoomId) : that.labRoomId != null) return false;
        if (campus != null ? !campus.equals(that.campus) : that.campus != null) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (roomName != null ? !roomName.equals(that.roomName) : that.roomName != null) return false;
        if (roomType != null ? !roomType.equals(that.roomType) : that.roomType != null) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (managerName != null ? !managerName.equals(that.managerName) : that.managerName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labRoomId != null ? labRoomId.hashCode() : 0;
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + (int) capacity;
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (managerName != null ? managerName.hashCode() : 0);
        return result;
    }
}
