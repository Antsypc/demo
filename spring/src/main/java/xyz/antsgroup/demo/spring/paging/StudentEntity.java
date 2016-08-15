package xyz.antsgroup.demo.spring.paging;

/**
 * 学生数据库映射实体对象
 * 表 labms.student
 */
public class StudentEntity {

    private String studentId;
    private String password;
    private String name;
    private String department;
    private String major;
    private String classes;
    private String gender;
    private Integer inYear;
    private String nativePlace;
    private String phone;
    private String email;

    /*
    studentId CHAR(13) NOT NULL PRIMARY KEY,# 学号
    password VARCHAR(26) NOT NULL,          # 密码
    name VARCHAR(20) NOT NULL,              # 姓名
    department VARCHAR(20) NOT NULL,        # 学院
    major VARCHAR(20) NOT NULL,             # 专业
    classes VARCHAR(20) NOT NULL,           # 班级
    gender VARCHAR(3) NOT NULL,             # 性别
    inYear SMALLINT NOT NULL,               # 入学年份
    nativePlace VARCHAR(50) NOT NULL,       # 籍贯
    phone CHAR(13),                         # 电话
    email VARCHAR(30)                       # 邮箱
     */

    public StudentEntity() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getInYear() {
        return inYear;
    }

    public void setInYear(Integer inYear) {
        this.inYear = inYear;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
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
        return "StudentEntity{" +
                "studentId='" + studentId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", gender='" + gender + '\'' +
                ", inYear=" + inYear +
                ", nativePlace='" + nativePlace + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
