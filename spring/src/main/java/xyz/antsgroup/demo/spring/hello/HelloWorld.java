package xyz.antsgroup.demo.spring.hello;

/**
 * Created by ants_ypc on 10/11/15.
 */
public class HelloWorld {

    private String name;
    private String info;
    private int age;
    private double height;
    private Car myCar;

    public String getName() {
        return name;
    }

    public Car getMyCar() {
        return myCar;
    }

    public HelloWorld() {
        System.out.println("constructer");
    }
    public HelloWorld(String name, String info, int age) {
        System.out.println("constructer1");
        this.name = name;
        this.info = info;
        this.age = age;
    }

    public HelloWorld(String name, String info, double height) {
        System.out.println("constructer2");
        this.info = info;
        this.name = name;
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMyCar(Car myCar) {
        this.myCar = myCar;
    }
    public void hello() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", myCar=" + myCar +
                '}';
    }
}
