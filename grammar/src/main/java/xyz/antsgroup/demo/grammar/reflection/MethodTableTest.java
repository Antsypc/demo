package xyz.antsgroup.demo.grammar.reflection;

import java.lang.reflect.*;

/**
 * 使用 cl.getMethod("methodName", double.class); 调用任意类的方法
 * 使用 invoke 进行执行该 method
 * 后文还有一个例子
 */
public class MethodTableTest
{
    public static void main(String[] args) throws Exception
    {
        // get method pointers to the square and sqrt methods
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        // print tables of x- and y-values

        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * Returns the square of a number
     * @param x a number
     * @return x squared
     */
    public static double square(double x)
    {
        return x * x;
    }

    /**
     * Prints a table with x- and y-values for a method
     * @param from the lower bound for the x-values
     * @param to the upper bound for the x-values
     * @param n the number of rows in the table
     * @param f a method with a double parameter and double return value
     */
    public static void printTable(double from, double to, int n, Method f)
    {
        // print out the method as table header
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x += dx)
        {
            try
            {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

//    // 调用 RestoreIPAddresses 类的 private boolean isValidWithPattern(String s)
//    @Test
//    public void testIsValidWithPattern() throws Exception {
//        Method method = RestoreIPAddresses.class.getDeclaredMethod("isValidWithPattern", String.class);   // 从第二个参数开始依次是方法参数
//        method.setAccessible(true);   // 如果该方法是public则不用执行此步
//        assertTrue((Boolean) method.invoke(new RestoreIPAddresses(), "10"));  // 如果方法是static,第一个参数是null
//
//    }