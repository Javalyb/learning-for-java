package priv.lyb.study.base.rtti;


/**
 * @author LiuYingBo 2021/01/27 01:12
 */
class Base {
}

class Derived extends Base {
}

public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("Object Class " + x.getClass());

        System.out.println("x instanceof Base " + (x instanceof Base));

        System.out.println("x instanceof Driver " + (x instanceof Derived));

        System.out.println("Base.class.isInstance(x) " + Base.class.isInstance(x));

        System.out.println("Derived.class.isInstance(x) " + Derived.class.isInstance(x));

        System.out.println("Base.class==x.getClass() " + (Base.class == x.getClass()));

        System.out.println("Derived.class==x.getClass() " + (Derived.class == x.getClass()));

        System.out.println("x.getClass().equals(Base.class) "+x.getClass().equals(Base.class));

        System.out.println("x.getClass().equals(Derived.class) "+(x.getClass().equals(Derived.class)));

    }

    public static void main(String[] args) {
//        test(new Base());
        test(new Derived());
    }
}
