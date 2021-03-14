package priv.lyb.study.base.annotation.ohjava.annotations;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author LiuYingBo 2021/01/15 14:07
 */
public class UserCaseTracker {
    static void trackerUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getMethods()) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (null != uc) {
                System.out.println(uc.id() + " " + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        useCases.forEach(i -> System.out.println("Missing use case" + i));
    }

    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(40, 50).boxed().collect(Collectors.toList());
        trackerUseCases(useCases, PasswordUtils.class);
    }
}
