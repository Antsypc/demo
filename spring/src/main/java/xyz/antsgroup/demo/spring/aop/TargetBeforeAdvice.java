package xyz.antsgroup.demo.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置增强
 *
 * Created by Ants Young on 2016/7/14.
 */
public class TargetBeforeAdvice implements MethodBeforeAdvice {

    /**
     * 在目标类方法调用前执行
     *
     * @param method 目标类方法
     * @param objects 方法参数
     * @param o 目标类实例
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String client = (String) objects[0];
        System.out.println("before advice: Hello " + client + "." + o.getClass().getName() + "." + method.getName());
    }
}
