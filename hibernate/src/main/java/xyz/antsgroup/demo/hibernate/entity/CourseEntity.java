package xyz.antsgroup.demo.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "course", schema = "", catalog = "labms")
public class CourseEntity {
    private int courseId;
    private String courseName;
    private String courseClass;
    private int timeFrom;
    private int timeTo;
    private String teacherId;
    private String teacherName;
    private String coursewareUrl;
    private String description;

    @Id
    @Column(name = "courseId", nullable = false, insertable = true, updatable = true)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "courseName", nullable = false, insertable = true, updatable = true, length = 255)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "courseClass", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
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
    @Column(name = "timeTo", nullable = false, insertable = true, updatable = true)
    public int getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(int timeTo) {
        this.timeTo = timeTo;
    }

    @Basic
    @Column(name = "teacherId", nullable = false, insertable = true, updatable = true, length = 8)
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacherName", nullable = true, insertable = true, updatable = true, length = 20)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "coursewareURL", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCoursewareUrl() {
        return coursewareUrl;
    }

    public void setCoursewareUrl(String coursewareUrl) {
        this.coursewareUrl = coursewareUrl;
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

        CourseEntity that = (CourseEntity) o;

        if (courseId != that.courseId) return false;
        if (timeFrom != that.timeFrom) return false;
        if (timeTo != that.timeTo) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (courseClass != null ? !courseClass.equals(that.courseClass) : that.courseClass != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (coursewareUrl != null ? !coursewareUrl.equals(that.coursewareUrl) : that.coursewareUrl != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseClass != null ? courseClass.hashCode() : 0);
        result = 31 * result + timeFrom;
        result = 31 * result + timeTo;
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (coursewareUrl != null ? coursewareUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
