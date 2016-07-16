package xyz.antsgroup.demo.spring.transaction.entity;

/**
 * 管理员实体类
 * Created by Ants Young on 2016/7/16.
 */
public class LabManager {
    private String labManagerId;
    private String password;
    private String name;
    private String position;
    private String gender;
    private String phone;
    private String email;

    public LabManager() {
    }

    public LabManager(String labManagerId, String password, String name, String position, String gender, String phone, String email) {
        this.labManagerId = labManagerId;
        this.password = password;
        this.name = name;
        this.position = position;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public String getLabManagerId() {
        return labManagerId;
    }

    public void setLabManagerId(String labManagerId) {
        this.labManagerId = labManagerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LabManager{" +
                "labManagerId='" + labManagerId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
