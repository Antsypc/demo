package xyz.antsgroup.demo.grammar.collection.set;

import java.util.*;

/**
 * TreeSet 有序的集合类,实际使用 TreeMap 保存元素, TreeMap 使用红黑树实现.
 *
 * 1. 不能直接修改元素,不能通过序号遍历,不允许 null.
 *
 *
 * 将元素存入TreeSet中,并按照Item的描述排序
 *
 * 加入TreeSet中的元素必须实现 Comparable<E> 接口,这是由于TreeSet加入元素时自动排序,需要进行比较
 * 当元素顺序不重要时,不提倡使用TreeSet,使用HashSet
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        /**
         * 构造方法
         */
        TreeSet<Item> parts = new TreeSet<>();  // Item 本身实现了 Comparable 接口
        SortedSet<Item> sortByDescription = new TreeSet<>(
                // 自定义排序规则
                new Comparator<Item>() {
                    public int compare(Item a, Item b) {
                        String descrA = a.getDescription();
                        String descrB = b.getDescription();
                        return descrA.compareTo(descrB);
                    }
                });

        /**
         * 增删改查
         * 添加时自动根据红黑树规则排序;
         * 删除时只能删除指定元素,当然,可以在 iterator 的适合删除;
         * 不能直接修改元素!不能直接修改元素!不能直接修改元素!
         * 由于是有序的,所以查找操作比较丰富.
         */
        parts.add(new Item("a", 1)); // 还有 addAll(Collection<> c)
        parts.addAll(new ArrayList<Item>() {{
            add(new Item("b", 2));
            add(new Item("c", 3));
            add(new Item("d", 4));
            add(new Item("p", 1));
        }});
        parts.remove(new Item("b", 1));

        // 获取最大最小元素,默认从小到大排序,没有则抛出异常 NoSuchElementException
        Item item = parts.first(); item = parts.last();

        // 获取最大最小元素,并删除,没有则返回 null
        item = parts.pollFirst(); item = parts.pollLast();

        // 获取集合中大于等于 item 的最小元素,无则返回 null,即 item 的上一个元素(如果集合中有4,7.item=6,返回4;item=7,返回7)
        Item item1 = parts.ceiling(item);
        // 获取集合中小于等于 item 的最大元素,无则返回 null,即 item 的上一个元素
        item1 = parts.floor(item);
        // 严格小于 item 的元素,无则 null
        item1 = parts.lower(item);
        // 严格大于 item 的元素,无则 null
        item1 = parts.higher(item);

        /**
         * 遍历
         */
        Iterator<Item> iterator = parts.iterator();
        Iterator<Item> desIterator = parts.descendingIterator();



        /**
         * tailSet,subSet,headSet,descendingSet 可以返回子集
         */

    }


}
