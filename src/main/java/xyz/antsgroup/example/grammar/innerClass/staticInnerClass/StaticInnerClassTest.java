package xyz.antsgroup.example.grammar.innerClass.staticInnerClass;

/**
 * Created by ants_ypc on 2/24/16.
 *
 * 静态内部类
 * 有时使用内部类只是为了把类隐藏在一个类的内部,不需要访问外围类的域,使用静态内部类就可以避免产生外围类的引用.
 */
public class StaticInnerClassTest
{
    public static void main(String[] args)
    {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++)
            d[i] = 100 * Math.random();
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg
{
    /**
     * A pair of floating-point numbers
     */
    public static class Pair
    {
        private double first;
        private double second;

        /**
         * Constructs a pair from two floating-point numbers
         * @param f the first number
         * @param s the second number
         */
        public Pair(double f, double s)
        {
            first = f;
            second = s;
        }

        /**
         * Returns the first number of the pair
         * @return the first number
         */
        public double getFirst()
        {
            return first;
        }

        /**
         * Returns the second number of the pair
         * @return the second number
         */
        public double getSecond()
        {
            return second;
        }
    }

    /**
     * Computes both the minimum and the maximum of an array
     * @param values an array of floating-point numbers
     * @return a pair whose first element is the minimum and whose second element
     * is the maximum
     */
    public static Pair minmax(double[] values)
    {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : values)
        {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }
}