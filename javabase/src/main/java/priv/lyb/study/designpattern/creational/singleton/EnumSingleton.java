package priv.lyb.study.designpattern.creational.singleton;

/**
 * @author LiuYingBo 2021/02/11 21:03
 */
public enum EnumSingleton {
    INSTANCE;
    EnumSingleton(){
        System.out.println("初始化");
    }

    static {
        System.out.println("static");
    }

    void fun(){
        System.out.println("方法");
    }


    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE==EnumSingleton.INSTANCE);
    }
}
