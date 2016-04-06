package xyz.antsgroup.demo.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
	/*
	 * 1.更改默认的测试运行器为RunWith(Parameterized.class)
	 * 2.声明变量来存放预期值和结果值
	 * 3.声明一个返回值为 collection 的公共静态方法，并使用 @Parameters 进行修饰
	 * 4.为测试类声明一个带有参数的公共构造函数，并在其中为之声明变量赋值
	 */
	double expected =0;
	double input1 = 0;
	double input2 = 0;
	
	@Parameters
	public static Collection<Object[]> t() {
		return Arrays.asList(new Object[][]{
				{3,1,2},    // 依次为期望值expected,输入值input1,输入值input2
				{4,2,2}
		}) ;
	}
	
	public ParameterTest(double expected,double input1,double input2) {
		this.expected = expected;
		this.input1 = input1;
		this.input2 = input2;
	}
	
	@Test
	public void testAdd() {
		assertEquals(expected, new Calculator().add(input1, input2), 0);
	}

}
