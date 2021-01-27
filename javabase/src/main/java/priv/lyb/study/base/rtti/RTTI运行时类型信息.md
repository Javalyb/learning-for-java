RTTI(RunTime Type Information): 运行时类型信息。能够在程序运行时发现，使用和转换类型信息;

编译期和运行期的区别:
    1.编译期执行:
        1.常量;
        2.方法重载: 在编译期间就必须确定调用的是哪个方法;
        3.泛型类型擦除: 为了兼容JDK1.5之前的代码，;
    2.运行期执行:
        1.反射;
        2.动态代理;

Java在运行时识别对象和类信息的两种方式:
    1.RTTI: 在运行时，识别一个对象的类型;
        1.instanceof: 检测对象是否是某个类型的实例;
        2.isInstance(): 提供一种动态测试对象类型的方法;
        3.Class1.isAssignableForm(Class2): 判断Class1是否为Class2的父类;
    2.反射: 使用Class对象来实现。在运行时使用类的信息;

RTTI和反射的区别:
    RTTI在编译时打开并检查.class文件。反射在运行时才打开并检查文件;

Class对象(类型对象):
创建方式:
    1.Class.forName(类全名，会初始化Class);
    2.Class.class(类字面常量，不会初始化Class);
        1.可以应用于普通类，接口，数组以及基本数据类型。
          对于基本数据类型的包装类还有另一个标准字段.TYPE。TYPE字段是一个引用，指向对象的基本类型的Class对象;
    3.对象.getClass();

1.用来使用RTTI。当编译一个类时，会产生一个Class对象保存在同名的.class文件中;
2.何时加载类: 创建第一个对类的静态成员(static方法，构造方法，非常量的static字段(不能指向其他常量))的引用时，就会加载类。构造器也是static方法。
            因此，在运行之前类并没有完全加载完，很多部分在需要时才被加载;
3.无论何时，想要在运行时使用类型信息，必须先获得Class对象的引用;

类加载过程(类的初始化):
    1.加载:
        通过类加载器查找classpath下的字节码，加载进虚拟机;
    2.链接:
        验证字节码，为static分配存储空间，解析类中其他类的引用;
    3.初始化(初始化存储空间):
        先初始化父类static块，再初始化子类static块;
    
newInstance(): 得到的是Object的引用，必须指定无参构造器;

Class泛型:
    Class的泛型不能作用于继承。可以使用通配符Class<?>，Class<? extends 类型>，Class<? super 类型>;
    Class对象.getSuperclass(): 返回的是父类的类型对象(Class对象)，需要用Class<? super 类型>接收。
        原因: 这个父类的类型对象并不确定(可能集联继承)，所以通过通配符对象的newInstance返回的是一个不确定的Object对象;

case(): 类型转化，将类型对象转化为普通对象;

instanceof，isInstance和==的比较:
    instanceof，isInstance可用于派生类。
    ==比较的是实际的对象;


    
    

