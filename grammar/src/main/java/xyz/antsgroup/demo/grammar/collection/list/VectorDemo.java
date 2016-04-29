package xyz.antsgroup.demo.grammar.collection.list;

import java.util.Vector;

/**
 * Vector 可以说,是一个线程安全的 ArrayList, @see xyz.antsgroup.demo.grammar.collection.list.ArrayListDemo
 * 区别在于空间不够时,是增长一倍,而不是 ArrayList 那样的一半.
 *
 * @author ants_ypc
 * @version 1.0 4/29/16
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
    }
}
