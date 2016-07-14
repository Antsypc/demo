package xyz.antsgroup.demo.spring.aop.pointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import xyz.antsgroup.demo.spring.aop.Target2;

import java.lang.reflect.Method;

/**
 * 动态切面
 * DynamicMethodMatcherPointcut 默认匹配所有类的所有方法
 * 在生成代理对象时,会对被代理对象的所有方法依次进行 getClassFilter 和 matches 静态检查.
 * 在正式调用对象的方法时,才进行 matches 动态检查.
 *
 * 这个类既有静态也有动态检查,动态很费时间.Spring 中如果创建代理对象时静态检查已经不匹配,则在运行时不进行动态检查.
 *
 * Created by Ants Young on 2016/7/14.
 */
public class TargetDynamicPointcut extends DynamicMethodMatcherPointcut {

    /**
     * 对类进行静态切入点检查
     * 限制对 Target2 可以切入
     * @return ClassFilter
     */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                System.out.println("getClassFilter() 对" + aClass.getName() + " 做静态检查");
                return Target2.class.isAssignableFrom(aClass);
            }
        };
    }

    /**
     * 对方法进行静态切点检查
     * @param method 调用的方法
     * @param targetClass 目标实例的类
     * @return 是否匹配,即是否需要代理切入
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("调用 matches(Method method, Class<?> targetClass) 对"
                + targetClass.getName() + "." + method.getName() + "方法,进行静态检查");
        return "say".equals(method.getName());
    }

    /**
     * 对方法进行动态切点检查
     * @param method 调用的方法
     * @param aClass 目标实例的类
     * @param objects 参数列表
     * @return 是否匹配,即是否需要代理切入
     */
    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("调用 matches(Method method, Class<?> aClass, Object... objects) 对"
                + aClass.getName() + "." + method.getName() + "方法,进行动态检查");
        return ((String) objects[0]).startsWith("s");
    }

}
