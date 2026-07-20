package priv.lyb.study.base.annotation; // 声明包路径，组织类文件

import java.lang.reflect.Method; // 导入反射 Method 类，用于获取方法信息
import java.util.List; // 导入 List 集合接口
import java.util.stream.Collectors; // 导入 Collectors 工具类，用于流收集操作
import java.util.stream.IntStream; // 导入 IntStream 类，用于生成整数流

/**
 * @author LiuYingBo 2021/01/15 02:33
 */
public class TestAnnotationTracker { // 类定义：测试注解追踪器
    public static void getAnnotation(Class<?> t){ // 静态方法：获取传入类上的注解信息
        for (Method declaredMethod : t.getDeclaredMethods()) { // 遍历类中声明的所有方法（不包括继承的方法）
            TestAnnotation testAnnotation = declaredMethod.getAnnotation(TestAnnotation.class); // 获取方法上的 TestAnnotation 注解实例
            if(testAnnotation != null){ // 判断该方法是否标注了 TestAnnotation 注解
                System.out.println(testAnnotation.id() + " " + testAnnotation.description()); // 打印注解的 id 和 description 属性值
            }
        }
    }
    public static void main(String[] args) { // 程序入口 main 方法
        List<Integer> idList = IntStream.range(10,50).boxed().collect(Collectors.toList()); // 生成10到49的整数序列，装箱后收集为List
        System.out.println(idList.toString()); // 打印生成的整数列表
        getAnnotation(Test.class); // 调用 getAnnotation 方法，传入 Test.class 进行注解解析
    }
}
