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
         * ArrayList 大小自动调增,当不够时采用复制原来的元素到1.5倍空间的新数组,
         * 所以代价很大,最好能估算合适大小.
         */
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list0 = new ArrayList<>(20);  // 初始化容量,默认是10.
        list0.ensureCapacity(100);  // 如果原本有元素就拷贝到一个容量为100的新数组,如果原本数组容量大于100,放弃容量改变
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
        // for : 由于可以直接数组索引找,所以从效率上可能比 for-each 还要快
        for (int i = 0, len = list.size(); i < len; i++) {
            System.out.println(list.get(i));
        }

        // for-each : 本质是 Iterator, 但是 for-each 不能对元素 remove
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
