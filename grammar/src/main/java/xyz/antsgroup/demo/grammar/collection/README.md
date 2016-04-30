Java 集合类总结
==========
> [Java之美[从菜鸟到高手演变]之集合类](http://blog.csdn.net/zhangerqing/article/details/8122075)

- `java.util.AbstractCollection<E> (implements java.util.Collection<E>)`
    - `java.util.AbstractList<E> (implements java.util.List<E>)`
        - `java.util.AbstractSequentialList<E>`
            - `java.util.LinkedList<E> (implements java.lang.Cloneable, java.util.Deque<E>, java.util.List<E>, java.io.Serializable)` 用双向循环链表实现的List,相对 ArrayList 在插入和删除操作多效率更高.
        - `java.util.ArrayList<E> (implements java.lang.Cloneable, java.util.List<E>, java.util.RandomAccess, java.io.Serializable)` 内部是用数组存储实现的,适合需要大量随机访问,不太需要插入删除操作的情况.
        - `java.util.Vector<E> (implements java.lang.Cloneable, java.util.List<E>, java.util.RandomAccess, java.io.Serializable)` 线程安全的 ArrayList.
            - `java.util.Stack<E>` Stack 继承自 Vector,线程安全的栈.
    - `java.util.AbstractQueue<E> (implements java.util.Queue<E>)`
        - `java.util.PriorityQueue<E> (implements java.io.Serializable)` 优先队列,堆实现,可直接获得最大或最小值,有序.
    - `java.util.AbstractSet<E> (implements java.util.Set<E>)`
        - `java.util.EnumSet<E> (implements java.lang.Cloneable, java.io.Serializable)`
        - `java.util.HashSet<E> (implements java.lang.Cloneable, java.io.Serializable, java.util.Set<E>)` 拥有集合的性质,内部实际上是用 HashMap 存储.
        - `java.util.LinkedHashSet<E> (implements java.lang.Cloneable, java.io.Serializable, java.util.Set<E>)`
        - `java.util.TreeSet<E> (implements java.lang.Cloneable, java.util.NavigableSet<E>, java.io.Serializable)` 底层用 HashMap,使用红黑树(平衡二叉树),有序.
    - `java.util.ArrayDeque<E> (implements java.lang.Cloneable, java.util.Deque<E>, java.io.Serializable)` 数组实现的双端队列,与 LinkedList 对应.

- `java.util.AbstractMap<K,V> (implements java.util.Map<K,V>)`
    - `java.util.EnumMap<K,V> (implements java.lang.Cloneable, java.io.Serializable)`
    - `java.util.HashMap<K,V> (implements java.lang.Cloneable, java.util.Map<K,V>, java.io.Serializable)`
        - `java.util.LinkedHashMap<K,V> (implements java.util.Map<K,V>)`
    - `java.util.IdentityHashMap<K,V> (implements java.lang.Cloneable, java.util.Map<K,V>, java.io.Serializable)`
    - `java.util.TreeMap<K,V> (implements java.lang.Cloneable, java.util.NavigableMap<K,V>, java.io.Serializable)` 红黑树实现.
    - `java.util.WeakHashMap<K,V> (implements java.util.Map<K,V>)`
