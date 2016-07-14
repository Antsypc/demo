package xyz.antsgroup.demo.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强
 * 分别在方法调用之前和返回后调用
 *
 * Created by Ants Young on 2016/7/14.
 */
public class TargetMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String client = (String) args[0];
        System.out.println("method interceptor, before:" + client);

        Object object = methodInvocation.proceed();

        System.out.println("method interceptor, after.");

        return object;
    }
}
