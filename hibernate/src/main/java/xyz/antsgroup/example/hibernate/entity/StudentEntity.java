package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "student", schema = "", catalog = "labms")
public class StudentEntity {
    private String studentId;
    private String password;
    private String name;
    private String department;
    private String major;
    private String studentClass;
    private String gender;
    private short inYear;
    private String nativePlace;
    private String phone;
    private String email;

    @Id
    @Column(name = "studentId", nullable = false, insertable = true, updatable = true, length = 13)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 26)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "department", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "major", nullable = false, insertable = true, updatable = true, length = 20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "studentClass", nullable = false, insertable = true, updatable = true, length = 20)
    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true, length = 3)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "inYear", nullable = false, insertable = true, updatable = true)
    public short getInYear() {
        return inYear;
    }

    public void setInYear(short inYear) {
        this.inYear = inYear;
    }

    @Basic
    @Column(name = "nativePlace", nullable = false, insertable = true, updatable = true, length = 50)
    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 13)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (inYear != that.inYear) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (studentClass != null ? !studentClass.equals(that.studentClass) : that.studentClass != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (nativePlace != null ? !nativePlace.equals(that.nativePlace) : that.nativePlace != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (studentClass != null ? studentClass.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (int) inYear;
        result = 31 * result + (nativePlace != null ? nativePlace.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
