package xyz.antsgroup.example.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class, JunitFlowTest.class, AnotationTest.class})
public class SuiteTest {
	/*
	 * 1.测试套件就是组织测试类一起运行的
	 * 
	 * 写一个作为测试套件的入口类，这个类里不包含其他的方法
	 * 更改测试运行器Suite.class
	 * 将要测试的类作为数组传入到Suite.SuiteClasses（{}）
	 * 2.测试套件类也可以包含其他的测试套件类,只需要将类名加入SuiteClasses中
	 */

}
