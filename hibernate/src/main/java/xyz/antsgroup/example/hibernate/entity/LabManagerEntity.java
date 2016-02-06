package xyz.antsgroup.example.hibernate.entity;

import javax.persistence.*;

/**
 * Created by ants_ypc on 2/5/16.
 */
@Entity
@Table(name = "labManager", schema = "", catalog = "labms")
public class LabManagerEntity {
    private String labManagerId;
    private String password;
    private String name;
    private String position;
    private String gender;
    private String phone;
    private String email;

    @Id
    @Column(name = "labManagerId", nullable = false, insertable = true, updatable = true, length = 8)
    public String getLabManagerId() {
        return labManagerId;
    }

    public void setLabManagerId(String labManagerId) {
        this.labManagerId = labManagerId;
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
    @Column(name = "position", nullable = false, insertable = true, updatable = true, length = 10)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 14)
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

        LabManagerEntity that = (LabManagerEntity) o;

        if (labManagerId != null ? !labManagerId.equals(that.labManagerId) : that.labManagerId != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labManagerId != null ? labManagerId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
