package xyz.antsgroup.demo.spring.aop;

/**
 * Created by Ants Young on 2016/7/14.
 */
public class Target2Delegate {
    private Target2 target2;

    public void service(String s) {
        target2.say(s);
        target2.serveTo(s);
    }

    public void setTarget2(Target2 target2) {
        this.target2 = target2;
    }
}
