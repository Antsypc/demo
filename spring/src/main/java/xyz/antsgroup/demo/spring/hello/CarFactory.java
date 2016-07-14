package xyz.antsgroup.demo.spring.hello;

/**
 * Created by Ants Young on 2016/7/12.
 */
public class CarFactory {

    public static Car getNiceCar() {
        return new Car("ferrary", "Nice car");
    }

    public Car getOneCar() {
        return new Car();
    }
}
