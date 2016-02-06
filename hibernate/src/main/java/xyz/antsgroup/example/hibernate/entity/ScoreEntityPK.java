package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ants_ypc on 2/5/16.
 */
public class ScoreEntityPK implements Serializable {
    private String studentId;
    private int courseId;

    @Column(name = "studentId", nullable = false, insertable = true, updatable = true, length = 13)
    @Id
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "courseId", nullable = false, insertable = true, updatable = true)
    @Id
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreEntityPK that = (ScoreEntityPK) o;

        if (courseId != that.courseId) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + courseId;
        return result;
    }
}
