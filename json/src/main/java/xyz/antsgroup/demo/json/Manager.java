package xyz.antsgroup.demo.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 */
public class Manager {
    private String name;
    private Integer age;

    @JsonDeserialize(using = MyDeserialize.class)
    private String location;

    @JsonDeserialize(using = DateTimeDeserialize.class)
    private Long time;

    public Manager() {
    }

    public Manager(String name, Integer age, String location, Long time) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", time=" + time +
                '}';
    }
}
