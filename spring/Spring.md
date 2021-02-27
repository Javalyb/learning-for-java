## IOC

IOC：控件反转，将手动创建对象的控制权反转交给Spring管理； DI：依赖注入，指在spring对象创建过程中，将对象属性通过配置注入到对象中；

## AOP：

## BeanFactory和ApplicationContext的区别：

BeanFactory采用延时加载，只在第一次getBean的时候才会初始化Bean。 ApplicationContext接口是BeanFactory的子接口，会在加载配置文件时初始化Bean；

## Bean的生命周期：![img.png](img.png)

创建对象： 1.从xml配置的Bean、注解Bean中读取Bean的定义，实例化Bean； 2.设置Bean的属性； 3.注入Aware的依赖(
BeanNameAware、BeanFactoryAware、ApplicationContextAware)；
4.执行前置Processor方法处理，BeanProcessor.postProcessorBeforeInitialization()； 5.指定自定义Bean的init-method方法；
6.执行后置Processor方法处理，BeanProcessor.postProcessorAfterInitialization()； 销毁对象： 7.执行Disposable.destory()；
8.执行自定义Bean的destory方法；

## Spring中解决循环依赖：三级缓存；

singletonObjects：用于存放完全初始化好的bean，该缓存中取出的bean可以直接使用； earlySingletonObjects：提前曝光的单例对象的cache，存放原始的bean对象，用于解决循环依赖；
singletonFactories：单例对象工厂的cache，存放bean工厂对象，用于解决循环依赖；

## Spring事务管理
