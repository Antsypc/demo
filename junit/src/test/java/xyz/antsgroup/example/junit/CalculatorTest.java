package xyz.antsgroup.example.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ants_ypc on 1/26/16.
 */
public class CalculatorTest {

    /**
     * 1.测试方法上必须使用 @Test 进行修饰
     * 2.测试方法必须使用 public void 进行修饰，不能带任何的参数
     * 3.新建一个源代码目录来存放我们的测试代码
     * 4.测试类的包应该和被测试类保持一致
     * 5.测试单元中的每个方法必须可以独立测试，测试方法间不能有任何的依赖
     * 6.测试类使用 Test 作为类名的后缀（不是必须）
     * 7.测试方法使用 test 作为方法名的前缀（不是必须）
     *
     * assert 方法主要有:
     * assertArrayEquals,
     * assertEquals,assertNotEquals,
     * assertFalse,assertTrue,
     * assertNotSame,assertSame,
     * assertNotNull,assertNull
     *
     * 注意:
     * 如果是数组一定使用assertArrayEquals,如果使用assertEquals将比较的是内存地址.
     */

    @Test
    public void testAdd() throws Exception {

        // assertEquals(double expected, double actual) 已被弃用
        // 新增的第三个参数表示 expected - actual 的值,在第三个数范围内都为true
        assertEquals(6.0, new Calculator().add(3,3), 0);

    }

    @Test
    public void testSub() throws Exception {
        assertEquals(3, new Calculator().sub(6,3), 0);

    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(2, new Calculator().divide(6,3), 0);

    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(4, new Calculator().multiply(2,2), 0);

    }
}
