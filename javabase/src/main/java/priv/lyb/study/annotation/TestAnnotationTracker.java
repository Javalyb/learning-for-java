package priv.lyb.study.annotation;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author LiuYingBo 2021/01/15 02:33
 */
public class TestAnnotationTracker {
    public static void getAnnotation(Class<?> t){
        for (Method declaredMethod : t.getDeclaredMethods()) {
            TestAnnotation testAnnotation = declaredMethod.getAnnotation(TestAnnotation.class);
            System.out.println(testAnnotation.id() + " " + testAnnotation.description());
        }
    }
    public static void main(String[] args) {
        List<Integer> idList = IntStream.range(10,50).boxed().collect(Collectors.toList());
        System.out.println(idList.toString());
        getAnnotation(Test.class);
    }
}
