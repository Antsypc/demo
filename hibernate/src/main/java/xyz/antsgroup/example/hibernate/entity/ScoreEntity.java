package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "score", schema = "", catalog = "labms")
@IdClass(ScoreEntityPK.class)
public class ScoreEntity {
    private String studentId;
    private int courseId;
    private String stuScore;

    @Id
    @Column(name = "studentId", nullable = false, insertable = true, updatable = true, length = 13)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "courseId", nullable = false, insertable = true, updatable = true)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "stuScore", nullable = false, insertable = true, updatable = true, length = 6)
    public String getStuScore() {
        return stuScore;
    }

    public void setStuScore(String stuScore) {
        this.stuScore = stuScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreEntity that = (ScoreEntity) o;

        if (courseId != that.courseId) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (stuScore != null ? !stuScore.equals(that.stuScore) : that.stuScore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + courseId;
        result = 31 * result + (stuScore != null ? stuScore.hashCode() : 0);
        return result;
    }
}
