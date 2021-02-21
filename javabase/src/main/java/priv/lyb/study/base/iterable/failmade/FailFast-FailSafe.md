引用文章:
    1.https://segmentfault.com/a/1190000016694292
    2.https://blog.csdn.net/biglxl/article/details/77462266
    3.https://mp.weixin.qq.com/s/AixdbEiXf3KfE724kg2YIw
fail-fast:
    快速失败: 
        是迭代java.util包下集合类时，发生add，remove，clear等涉及修改集合元素个数操作的一种错误检查机制，
        会抛出ConcurrentModificationException异常;
原理: 
    获取一个集合的迭代器对象时，迭代器会保存当前集合修改次数(modCount)的快照(expectedModCount)， 
    当集合修改次数发生改变(add,remove操作)时，快照(expectedModCount)并不会改变，当执行迭代器的next方法时判断modCount!=expectedModCount时， 
    会抛出ConcurrentModificationException异常;
    当集合发生变化时修改了modCount，同时赋值给了expectedModCount，则不会抛出异常; 
    因此不能根据抛出异常来判断是否执行了异常操作; 解决方式: 迭代器中删除可以用Iterator.remove方法;
    使用JUC中CopyOnWriteArrayList方法，CopyOnWriteArrayList没有继承AbstractList，只是实现了List接口，不会根据修改次数和快照判断抛出异常;

fail-safe:
    安全失败: 
        采用安全失败机制的集合，在遍历时不会直接访问集合对象，而是访问的该集合快照，所以不保证读取到的值和当前集合的状态是一致的; 
        java.util.concurrent包下的所有类都是采用安全失败的;
    
    
    