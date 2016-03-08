Java多线程递进说明
===========

该包阅读顺序:
* `ThreadTest.java`,简单多线程示例,继承Thread类或者实现Runnable接口.
* `lockConditionSynchronized`,简单同步机制.
* `blockingQueue`,高级同步方法,使用BlockingQueue进行类似生产者消费者的同步.
* `synchronizedCollection`,对集合操作同步的方法,Collections.synchronizedXxx()或者其他本身实现了同步的集合类.
* `callableFuture`,需要线程返回运行结果就是用他.
* `threadPool`,使用线程池高效利用系统资源.
* `forkJoin`,使用ForkJoinTask<>做更高效的并行计算,将同一个任务分块,分别计算后汇总结果.