package xyz.antsgroup.demo.spring.aop;

/**
 * Created by Ants Young on 2016/7/14.
 */
public class Target2 {

    public void say(String name) {
        System.out.println("greet to " + name);
    }

    public void serveTo(String name) {
        System.out.println("serve to " + name);
    }

    @Override
    public String toString() {
        return "Target2{}" + super.toString();
    }
}
