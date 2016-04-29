package xyz.antsgroup.demo.grammar.collection.list;

import java.util.Stack;

/**
 * Stack 继承自 Vector,线程安全的栈.
 * 由于 Vector 内部是数组实现,所以判断 stack 是否为空不能通过返回是否为 null 来判断,应该用 empty().
 *
 * @author ants_ypc
 * @version 1.0 4/29/16
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();    // 只能初始化为空栈

        /**
         * 除了 Vector 的方法外,额外有下面功能
         */
                         stack.push("ad");
        String element = stack.peek();  // 没有则抛出异常
               element = stack.pop();   // 没有则抛出异常
        boolean isEmpty= stack.empty();
        int loc = stack.search("ad");   // 没有则返回 -1

    }
}
