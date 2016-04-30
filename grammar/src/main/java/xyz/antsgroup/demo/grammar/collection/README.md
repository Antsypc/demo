Java 集合类总结
==========
> [Java之美[从菜鸟到高手演变]之集合类](http://blog.csdn.net/zhangerqing/article/details/8122075)

- `java.util.AbstractCollection<E> (implements Collection<E>)`
    - `java.util.AbstractList<E> (implements List<E>)`
        - `java.util.AbstractSequentialList<E>`
            - `java.util.LinkedList<E> (implements Cloneable, Deque<E>, List<E>, Serializable)` 用双向循环链表实现的List,相对 ArrayList 在插入和删除操作多效率更高.
        - `java.util.ArrayList<E> (implements java.lang.Cloneable, List<E>, RandomAccess, Serializable)` 内部是用数组存储实现的,适合需要大量随机访问,不太需要插入删除操作的情况.
        - `java.util.Vector<E> (implements java.lang.Cloneable, List<E>, RandomAccess, Serializable)` 线程安全的 ArrayList.
            - `java.util.Stack<E>` Stack 继承自 Vector,线程安全的栈.
    - `java.util.AbstractQueue<E> (implements Queue<E>)`
        - `java.util.PriorityQueue<E> (implements   Serializable)` 优先队列,堆实现,可直接获得最大或最小值,有序.
    - `java.util.AbstractSet<E> (implements Set<E>)`
        - `java.util.EnumSet<E> (implements java.lang.Cloneable, Serializable)` 只能使用静态工厂获取对象,其他操作方法与普通 set 无异.
        - `java.util.HashSet<E> (implements java.lang.Cloneable, Serializable, Set<E>)` 拥有集合的性质,内部实际上是用 HashMap 存储.
        - `java.util.LinkedHashSet<E> (implements java.lang.Cloneable, Serializable, Set<E>)` LinkedHashSet 继承自HashSet, 只不过使用是用链表实现, 内部使用 LinkedHashMap 保存元素.
        - `java.util.TreeSet<E> (implements java.lang.Cloneable, NavigableSet<E>, Serializable)` TreeSet 有序的集合类,实际使用 TreeMap 保存元素, TreeMap 使用红黑树实现.
    - `java.util.ArrayDeque<E> (implements java.lang.Cloneable, Deque<E>, Serializable)` 数组实现的双端队列,与 LinkedList 对应.

- `java.util.AbstractMap<K,V> (implements Map<K,V>)`
    - `java.util.EnumMap<K,V> (implements java.lang.Cloneable, Serializable)`
    - `java.util.HashMap<K,V> (implements java.lang.Cloneable, Map<K,V>, Serializable)` HashMap 通过对键 hash,数组实现
        - `java.util.LinkedHashMap<K,V> (implements Map<K,V>)` 操作上与 HashMap 无异,但是LinkedHashMap 保留了插入顺序,实现了 LRU 算法:最近使用的放在最后.
    - `java.util.IdentityHashMap<K,V> (implements java.lang.Cloneable, Map<K,V>, Serializable)`
    - `java.util.TreeMap<K,V> (implements java.lang.Cloneable, NavigableMap<K,V>, Serializable)` 红黑树实现的 map
    - `java.util.WeakHashMap<K,V> (implements Map<K,V>)`
