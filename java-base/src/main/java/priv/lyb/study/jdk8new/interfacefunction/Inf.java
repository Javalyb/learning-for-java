package priv.lyb.study.jdk8new.interfacefunction;

/**
 * @author LiuYingBo 2021/01/11 17:01
 */
public interface Inf {
    static double div(double a, double b) {
        return a / b;
    }

    int add(int a, int b);

    default int mul(int a, int b) {
        return a * b;
    }
}

