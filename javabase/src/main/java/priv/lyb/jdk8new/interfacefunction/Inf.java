package priv.lyb.jdk8new.interfacefunction;

/**
 * @author LiuYingBo 2021/01/11 17:01
 */
public interface Inf{
    int add(int a, int b);
    default int mul(int a, int b){
        return a * b;
    }
    static double div(double a, double b){
        return a / b;
    }
}

