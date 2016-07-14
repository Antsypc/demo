package xyz.antsgroup.demo.spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置增强
 * 在目标类方法调用后执行
 * Created by Ants Young on 2016/7/14.
 */
public class TargetAfterReturningAdvice implements AfterReturningAdvice {

    /**
     * 被切入方法返回后执行
     *
     * @param o 目标方法返回值,如果返回为 void 则为 null
     * @param method 目标类方法
     * @param objects 方法参数
     * @param o1 被切入的目标类实例
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if (null != o) System.out.println("after returning " + o.toString());
        if (null != o1) System.out.println("after returning " + o1.toString());
    }
}
