package xyz.antsgroup.demo.spring.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by Ants Young on 2016/7/14.
 */
public class TargetThrowsAdvice implements ThrowsAdvice {


    /**
     * 发生异常会通过反射调用该方法.
     * 发生异常后将不会再调用任何 after 方法.
     *
     * @param method 可选
     * @param args 可选
     * @param target 可选
     * @param e 必须是 Throwable 或其子类
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("there is exception.");
    }
}
