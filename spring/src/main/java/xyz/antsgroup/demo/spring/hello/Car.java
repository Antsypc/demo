package xyz.antsgroup.demo.spring.hello;

/**
 * Created by ants_ypc on 10/11/15.
 */
public class Car {
    private String name;
    private String info;

    public Car() {
    }

    public Car(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
