package xyz.antsgroup.demo.grammar.object;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

/**
 * Object 类.
 *
 * toString(), compareTo(), equals(), hashCode() 这四个方法经常被重写,后两个必须同时重写,介绍重写方法及事项.
 * 当准备将对象存储在一些容器中，如HashMap，并且想要控制哈希冲突的时候，实现自己的.equals()方法和.hashCode()方法确实有它的意义.
 * hashCode() 和 equals() 方法确保同一个 UsersEntity 对象不会被重复添加到 Set 中. compareTo() 方法用于排序方法中生成应有的顺序。
 * 而重写方法 toString() 是在System.out.println() 被调用的时候控制每个 UsersEntity 对象的输出格式。
 *
 * 但是可以使用添加两个静态变量：COMPARATOR 和 TO_STRING 替换这四个方法.(下文实现使用了Java 8 lambda)
 *
 * @author ants_ypc
 * @version 1.0 3/9/16
 */
public class MyObject {
    public static void main(String[] args) {
        // 测试 COMPARATOR TO_STRING 的使用
        final Set<UsersEntity> people = new TreeSet<>(UsersEntity.COMPARATOR);
        people.add(new UsersEntity(1, "qq.com", "zhang", "zhangpass", 1));
        people.add(new UsersEntity(1, "qq.com", "zhang", "zhangpass", 1));
        people.add(new UsersEntity(2, "qq.com", "wang", "wangpass", 1));
        people.add(new UsersEntity(3, "qq.com", "yang", "yangpass", 1));
        people.add(new UsersEntity(4, "qq.com", "cao", "caopass", 1));
        people.stream().map(UsersEntity.TO_STRING).forEachOrdered(System.out::println);
    }

}

class UsersEntity implements Comparable<UsersEntity>{
    private int id;
    private String email;
    private String username;
    private String password;
    private int logtimes;

    public UsersEntity() {
    }

    public UsersEntity(int id, String email, String username, String password, int logtimes) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.logtimes = logtimes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLogtimes() {
        return logtimes;
    }

    public void setLogtimes(int logtimes) {
        this.logtimes = logtimes;
    }

    // equals 一般用来比较两个值是否等
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (logtimes != that.logtimes) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    // 取得对象的 hash 值
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + logtimes;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + id + username;
    }

    // 得到对象值的差值,规则是自定义的
    @Override
    public int compareTo(UsersEntity that) {
        if (this == that) return 0;
        else if (that == null) return 1;
        int comparison = this.id - that.id;
        if (comparison != 0) return comparison;
        comparison = this.username.compareTo(that.username);
        return comparison;
    }


    // 下面两个变量的使用可以替代上面四个重写方法
    public final static Comparator<UsersEntity> COMPARATOR = Comparator.comparing(UsersEntity::getId)
            .thenComparing(UsersEntity::getUsername);
    public final static Function<UsersEntity, String> TO_STRING = p -> p.getId() + " " + p.getUsername();
}