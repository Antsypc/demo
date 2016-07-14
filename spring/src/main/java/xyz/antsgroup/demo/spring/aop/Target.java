package xyz.antsgroup.demo.spring.aop;

/**
 * 需要被植入切面的目标类
 *
 * Created by Ants Young on 2016/7/14.
 */
public class Target implements ITarget {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }

    @Override
    public void serveTo(String name) throws Exception {
        System.out.println("serve to " + name);
        throw new Exception("something wrong");
    }

    @Override
    public String toString() {
        return "Target{}" + super.toString();
    }
}
