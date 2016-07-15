package xyz.antsgroup.demo.spring.aop.pointcut;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import xyz.antsgroup.demo.spring.aop.Target2Delegate;

/**
 * 复合切点
 * Created by Ants Young on 2016/7/15.
 */
public class TargetComposablePointcut {

    /**
     * 获取组合切点的最终 Pointcut: Target2Delegate 的 service 方法代表的流程切面和 serveTo 方法名的交集
     * ComposablePointcut 可以自由组合切入条件,提供三种交集(针对ClassFilter,MethodMatcher,Pointcut)
     * 和两种并集(针对ClassFilter,MethodMatcher)运算.
     *
     * @return Pointcut
     */
    public Pointcut getIntersectionPointcut() {
        ComposablePointcut com = new ComposablePointcut();
        Pointcut pointcut1 = new ControlFlowPointcut(Target2Delegate.class, "service");
        NameMatchMethodPointcut pointcut2 = new NameMatchMethodPointcut();
        pointcut2.addMethodName("serveTo");
        return com.intersection(pointcut1).intersection((Pointcut) pointcut2);
    }
}
