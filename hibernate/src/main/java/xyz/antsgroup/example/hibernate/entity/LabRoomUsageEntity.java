package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "labRoomUsage", schema = "", catalog = "labms")
public class LabRoomUsageEntity {
    private int labRoomUsageId;
    private int labRoomId;
    private int timeFrom;
    private Integer courseId;
    private String teacherId;
    private Short nowNum;
    private Short maxNum;
    private String isOk;
    private String description;

    @Id
    @Column(name = "labRoomUsageId", nullable = false, insertable = true, updatable = true)
    public int getLabRoomUsageId() {
        return labRoomUsageId;
    }

    public void setLabRoomUsageId(int labRoomUsageId) {
        this.labRoomUsageId = labRoomUsageId;
    }

    @Basic
    @Column(name = "labRoomId", nullable = false, insertable = true, updatable = true)
    public int getLabRoomId() {
        return labRoomId;
    }

    public void setLabRoomId(int labRoomId) {
        this.labRoomId = labRoomId;
    }

    @Basic
    @Column(name = "timeFrom", nullable = false, insertable = true, updatable = true)
    public int getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(int timeFrom) {
        this.timeFrom = timeFrom;
    }

    @Basic
    @Column(name = "courseId", nullable = true, insertable = true, updatable = true)
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "teacherId", nullable = true, insertable = true, updatable = true, length = 8)
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "nowNum", nullable = true, insertable = true, updatable = true)
    public Short getNowNum() {
        return nowNum;
    }

    public void setNowNum(Short nowNum) {
        this.nowNum = nowNum;
    }

    @Basic
    @Column(name = "maxNum", nullable = true, insertable = true, updatable = true)
    public Short getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Short maxNum) {
        this.maxNum = maxNum;
    }

    @Basic
    @Column(name = "isOk", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsOk() {
        return isOk;
    }

    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 30)
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

        LabRoomUsageEntity that = (LabRoomUsageEntity) o;

        if (labRoomUsageId != that.labRoomUsageId) return false;
        if (labRoomId != that.labRoomId) return false;
        if (timeFrom != that.timeFrom) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (nowNum != null ? !nowNum.equals(that.nowNum) : that.nowNum != null) return false;
        if (maxNum != null ? !maxNum.equals(that.maxNum) : that.maxNum != null) return false;
        if (isOk != null ? !isOk.equals(that.isOk) : that.isOk != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labRoomUsageId;
        result = 31 * result + labRoomId;
        result = 31 * result + timeFrom;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (nowNum != null ? nowNum.hashCode() : 0);
        result = 31 * result + (maxNum != null ? maxNum.hashCode() : 0);
        result = 31 * result + (isOk != null ? isOk.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
