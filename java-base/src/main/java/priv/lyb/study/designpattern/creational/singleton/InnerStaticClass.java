package priv.lyb.study.designpattern.creational.singleton;

/**
 * @author LiuYingBo 2021/02/11 20:59
 */
public class InnerStaticClass {
    private InnerStaticClass(){}

    private static class InnerStatic{
        private final static InnerStaticClass INNER_STATIC_CLASS = new InnerStaticClass();
    }

    public static InnerStaticClass getInstance(){
        return InnerStatic.INNER_STATIC_CLASS;
    }

    public static void main(String[] args) {
        System.out.println(InnerStaticClass.getInstance()==InnerStaticClass.getInstance());
    }
}
