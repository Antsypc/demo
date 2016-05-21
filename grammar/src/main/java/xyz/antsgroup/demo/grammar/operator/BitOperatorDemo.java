package xyz.antsgroup.demo.grammar.operator;

/**
 * 移位运算符操作.
 *
 * << 所有位左移一位,右边补0.
 * >> 所有位右移一位,左边补符号位
 * >>> 所有位右移一位,左边补0
 *
 * @author ants_ypc
 * @version 1.0 5/21/16
 */
public class BitOperatorDemo {

    public static void main(String[] args) {
        int a = 1, b = 0xF0, c = 0xF0000000, d = 0xE0000000;
        System.out.printf("%x\n", a << 1);
        System.out.printf("%x\n", a >> 1);
        System.out.printf("%x\n", a >>> 1);

        System.out.printf("%x\n", b >> 1);
        System.out.printf("%x\n", b >>> 1);

        System.out.printf("%x\n", c >> 1);
        System.out.printf("%x\n", c >>> 1);
        System.out.printf("%x\n", c << 1);

        System.out.printf("%x\n", d >> 1);
        System.out.printf("%x\n", d >>> 1);
        System.out.printf("%x\n", d << 1);

        System.out.println(d >> 1);
        System.out.println(d >>> 1);
        System.out.println(d << 1);
    }
}
