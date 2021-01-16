lambda表达式： 
    例子: new Thread(() -> {}).start();
    lambda表达式(() -> {})返回的是一个接口(Rannable)实例对象，且该接口只有唯一抽象方法(run);
    表达式语法：
    ![img_1.png](img_1.png)
    使用lambda表达式，需要使用函数式接口；
    函数式接口：接口中只能有唯一一个抽象方法，可以有多个非抽象方法。可以使用@FunctionalInterface注解定义为函数式接口，编译器会验证接口中抽象方法只能为一个，重写Object中的方法不算在内；
    lambda表达式实际是返回一个接口实例对象；
    ![img.png](img.png)
    使用lambda表达式注意点： 1.表达式返回的是接口的实例对象； 2.参数数量，是否需要返回值，返回值类型，可以选择合适的函数式接口； 可以参考jdk自带的函数式接口，在java.util.function包中； 常用jdk函数式接口：
    ![img_3.png](img_3.png)
    
    