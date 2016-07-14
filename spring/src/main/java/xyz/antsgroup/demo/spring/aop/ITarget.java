package xyz.antsgroup.demo.spring.aop;

/**
 * 需要被植入切面的目标类需要实现的接口
 *
 * Created by Ants Young on 2016/7/14.
 */
public interface ITarget {
    void greetTo(String name);

    void serveTo(String name) throws Exception;
}
