package xyz.antsgroup.demo.grammar.collection.list;

import java.util.*;

/**
 * ArrayList demo.
 *
 * ArrayList 内部是用数组存储实现的,适合需要大量随机访问,不太需要插入删除操作的情况.
 *
 * @author ants_ypc
 * @version 1.0 4/28/16
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        /**
         * 构造方法
         */
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list0 = new ArrayList<>(20);  // 初始化容量,默认是10
        ArrayList<String> list1 = new ArrayList<>(new ArrayList<>());   // 可以用另外一个 Collection 初始化,执行数组拷贝到新数组

        /**
         * 下面说明 增删改查
         */

        // append : 向尾部加一个元素或 Collection
        list.add("a");    list.addAll(new ArrayList<>());
        // insert : 上面两个操作可以指定位置,执行插入操作
        list.add(0, "b"); list.addAll(new ArrayList<>());

        // get : 由于内部是数组实现,可以根据索引,高效随机获取元素
        String str = list.get(0);

        // remove : 可以根据值,位置,全删
        list.remove(0);
        list.remove("a");
        list.removeAll(new ArrayList<String>() {{
            add("b");
            add("c");
        }});
        list.clear();

        list.add("d");
        // set : 修改指定位置的值,返回原来的值
        String previous = list.set(0, "z");

        /**
         * 遍历
         */
        // for-each
        list.add("a");
        list.add("d");
        for (String s : list)
            System.out.println(s);

        // Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String snow = iterator.next();
            //iterator.remove();  // 删除的是 next() 调用前经过的那个元素,指针始终存在两个元素中间.比如此时实际删除的是snow
        }

        // ListIterator : Iterator 只能向后遍历,这个既可以向前也可以向后遍历
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            previous = listIterator.previous();
            //listIterator.remove();  // 与 Iterator 同理,删除的是 next 或 previous 上次经过的那个元素 : the last element that was returned by next() or previous()
        }


        /**
         * 其他重要方法
         */
        // 判断是否包含元素
        boolean isContain = list.contains("b");
        isContain = list.containsAll(new ArrayList<String>(){{add("b"); add("c");}});
        list.indexOf("b");  // 如果返回 -1 说明没有这个元素

        // 转成数组 @see xyz.antsgroup.demo.grammar.collection.CollectionTransform
        String[] strings = new String[list.size()];
        strings = list.toArray(strings);

        // 子 List
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> subList = list.subList(0, 2);  // 结果中不包括索引为2的元素

        // 排序,使用归并排序
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }
}
