package priv.lyb.study.base.rtti;

/**
 * @author LiuYingBo 2021/01/26 14:21
 */
class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}
class Gum{
    static {
        System.out.println("Loading Gum");
    }
}
class Gandy{
    static {
        System.out.println("Loading Gandy");
    }
}
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Gandy();
        System.out.println("After creating Gandy");
        try {
            Class<?> c = Class.forName("priv.lyb.study.base.rtti.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
