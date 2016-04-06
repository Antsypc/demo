package xyz.antsgroup.demo.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "courseChooseLog", schema = "", catalog = "labms")
public class CourseChooseLogEntity {
    private int courseChooseLogId;
    private String studentId;
    private int labRoomUsageId;
    private Integer time;

    @Id
    @Column(name = "courseChooseLogId", nullable = false, insertable = true, updatable = true)
    public int getCourseChooseLogId() {
        return courseChooseLogId;
    }

    public void setCourseChooseLogId(int courseChooseLogId) {
        this.courseChooseLogId = courseChooseLogId;
    }

    @Basic
    @Column(name = "studentId", nullable = false, insertable = true, updatable = true, length = 13)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "labRoomUsageId", nullable = false, insertable = true, updatable = true)
    public int getLabRoomUsageId() {
        return labRoomUsageId;
    }

    public void setLabRoomUsageId(int labRoomUsageId) {
        this.labRoomUsageId = labRoomUsageId;
    }

    @Basic
    @Column(name = "time", nullable = true, insertable = true, updatable = true)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseChooseLogEntity that = (CourseChooseLogEntity) o;

        if (courseChooseLogId != that.courseChooseLogId) return false;
        if (labRoomUsageId != that.labRoomUsageId) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseChooseLogId;
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + labRoomUsageId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
