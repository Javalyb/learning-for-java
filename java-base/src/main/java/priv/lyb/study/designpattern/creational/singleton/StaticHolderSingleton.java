package priv.lyb.study.designpattern.creational.singleton;

/**
 * @author LiuYingBo 2021/02/04 05:11
 */
public class StaticHolderSingleton {
    private final static StaticHolderSingleton STATIC_HOLDER_SINGLETON = new StaticHolderSingleton();

    private StaticHolderSingleton() {
    }

    public static StaticHolderSingleton getInstance() {
        return STATIC_HOLDER_SINGLETON;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                System.out.println(StaticHolderSingleton.getInstance());
            }).start();
        }
    }
}
