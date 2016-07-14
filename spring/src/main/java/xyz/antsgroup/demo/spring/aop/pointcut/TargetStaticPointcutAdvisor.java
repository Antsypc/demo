package xyz.antsgroup.demo.spring.aop.pointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import xyz.antsgroup.demo.spring.aop.Target2;

import java.lang.reflect.Method;

/**
 * 静态普通方法匹配切面
 * Created by Ants Young on 2016/7/14.
 */
public class TargetStaticPointcutAdvisor extends StaticMethodMatcherPointcutAdvisor {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "say".equals(method.getName());
    }

    /**
     * 如果没有覆盖这个方法,默认是匹配所有类的 greetTo 方法.
     * @return ClassFilter
     */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return Target2.class.isAssignableFrom(aClass);
            }
        };
    }
}
