package xyz.antsgroup.example.grammar.collection;

import java.util.*;

/**
 * List,Set,数组之间的相互转换方法示例
 * @author ants_ypc
 * @version 1.0 2/25/16
 */

public class CollectionTransform {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        // list.add(1);//会产生java.lang.ArrayStoreException异常
        // 当list中的数据类型都一致时可以将list转化为数组
        // 不能转换为String[] array = (String[]) list.toArray();必须使用带参数的toArray(T[]);
        Object[] array = list.toArray();
        System.out.println("从list转换成的对象数组长度为：" + array.length);

        // List 转 数组 方法一:
        // 在转化为其它类型的数组时需要强制类型转换，并且，要使用带参数的toArray方法，参数为对象数组，
        // 将list中的内容放入参数数组中，当参数数组的长度小于list的元素个数时，会自动扩充数组的长度以适应list的长度
        String[] array1 = list.toArray(new String[0]);
        System.out.println("从list转换成的字符串数组长度为：" + array1.length);

        // List 转 数组 方法二(推荐):
        // 分配一个长度与list的长度相等的字符串数组
        String[] array2 = list.toArray(new String[list.size()]);
        System.out.println("从list转换成的字符串数组长度为：" + array2.length);
        list.clear();

        // 数组 转 List 方法一:
        for (String s : array1) {
            list.add(s);
        }
        System.out.println("将数组转换成list的元素个数为：" + list.size());
        list.clear();

        // 数组 转 List 方法二(推荐):
        Collections.addAll(list, array1);
        list.clear();

        // 数组 转 List 方法三:
        list = Arrays.asList(array1);
        System.out.println("将数组转换成list的元素个数为：" + list.size());

        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");

        ////////////////////////////////////////////////////
        // Set 转 数组 (与List 转 数组 一致),上面三种.
        array = set.toArray();
        array1 = set.toArray(new String[0]);
        array2 = set.toArray(new String[set.size()]);
        System.out.println("从Set转换成的对象数组长度为：" + array1.length);
        System.out.println("从Set转换成的字符串数组长度为：" + array2.length);

        // 数组 转 Set 方法一:
        // 将数组转换成List后，再用List构造Set
        set = new HashSet(Arrays.asList(array));
        System.out.println("将数组转换成Set的元素个数为：" + set.size());

        // 数组 转 Set 方法二:
        // 将Set清空，然后把数组转换成的list全部add
        set.clear();
        set.addAll(Arrays.asList(array1));
        System.out.println("将数组转换成Set的元素个数为：" + set.size());

        // 数组 转 Set 方法三:
        set.clear();
        Collections.addAll(set, array1);
        System.out.println("将数组转换成Set的元素个数为：" + set.size());
    }

}
