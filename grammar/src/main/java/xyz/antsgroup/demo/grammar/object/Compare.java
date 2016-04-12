package xyz.antsgroup.demo.grammar.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Comparator 与 Comparable 的区别.
 *
 * @author ants_ypc
 * @version 1.0 4/12/16
 */
public class Compare {
    /**
     * 输出结果:
     User{username='ub', age=43}
     User{username='ua', age=73}
     User{username='ua', age=73}
     User{username='ub', age=43}
     * @param args
     */
    public static void main(String[] args) {

        // 如果一个集合需要排序,但又不是基本的数字类型,那么他自身
        // 可以实现 Comparable 接口,重载 compareTo 方法,自定义
        // 对象比较方法.这样,在使用集合的排序方法时,就能自动排序.
        User ua = new User("ua", 73);
        User ub = new User("ub", 43);
        ArrayList<User> ulist = new ArrayList<>();
        ulist.add(ua);
        ulist.add(ub);
        Collections.sort(ulist);
        for (User u : ulist) System.out.println(u);

        // 如果一个类之前并没有实现 Comparable 接口,没有自定义比较规则.
        // 那么可以新建一个实现了 Comparator 接口的类,在这个类中重载
        // compare 方法.在调用 Collections 和 Arrays 的排序方法时,
        // 传入该对象也能实现自动排序.
        // 在下面这个例子中,如此使用,相当于覆盖了原来 User 类的对象比较方式
        ArrayList<User> ulist2 = new ArrayList<>();
        ulist2.add(ua);
        ulist2.add(ub);
        Collections.sort(ulist2, new UserCompare());
        for (User u : ulist2) System.out.println(u);

    }
}

class User implements Comparable {
    private String username;
    private int age;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 自定义 User 对象的比较方法:年龄大的大.
     * @param o 另一个 user
     * @return 0 相等, 1 大, -1 小
     */
    @Override
    public int compareTo(Object o) {
        User u = (User) o;
        if (this.age == u.getAge()) return 0;
        else return this.age > u.getAge() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}

class UserCompare implements Comparator<User> {
    /**
     * 改写原来的 User 比较规则, 按名字的字典序比较.
     * @param o1 一个 user
     * @param o2 另一个 user
     * @return 0 相等, 1 大, -1 小
     */
    @Override
    public int compare(User o1, User o2) {
        return o1.getUsername().compareTo(o2.getUsername());
    }
}