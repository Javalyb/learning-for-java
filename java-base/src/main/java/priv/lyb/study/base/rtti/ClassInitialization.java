package priv.lyb.study.base.rtti;

import java.util.Random;

/**
 * @author LiuYingBo 2021/01/26 15:51
 */
class Initable {
    static final int STATIC_FINAL3 = 50;
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initialazing Initable");
    }
    Initable(){
        System.out.println("Initialazing Initable 构造器");
    }
}

class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initialazing Initable2");
    }
}

class Initable3{
    static int staticNonFinal = 74;
    static {
        System.out.println("Initialazing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable =Initable.class;
        System.out.println("After creating Initable ref");

        System.out.println(Initable.STATIC_FINAL);

        System.out.println(Initable.STATIC_FINAL2);

        System.out.println(Initable2.staticNonFinal);

        Class initable3 = Class.forName("priv.lyb.study.base.rtti.Initable3");
        System.out.println("After creating Initable3 ref");

        System.out.println(Initable3.staticNonFinal);


    }
}
