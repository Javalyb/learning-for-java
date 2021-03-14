package priv.lyb.study.base.rtti;

/**
 * @author LiuYingBo 2021/01/26 14:38
 */
interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    Toy(){}
    Toy(int i) {

    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy(){
        super();
    }
    FancyToy(int i) {
        super(i);
    }
}

public class ToyTest {
    static int b = 0;

    static void printInfo(Class<?> cc) {
        System.out.println("Class name " + cc.getName());
        System.out.println("Class SimpleName " + cc.getSimpleName());
        System.out.println("Class Interfaces " + cc.getInterfaces());
        System.out.println("-----------------" + (++b) + "-------------------");
    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("priv.lyb.study.base.rtti.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find TancyToy");;
            System.exit(1);
        }
        printInfo(c);

        for (Class<?> anInterface : c.getInterfaces()) {
            printInfo(anInterface);
        }

        Class up = c.getSuperclass();
        printInfo(up);

        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiation");;
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");;
        }
        printInfo(obj.getClass());

    }
}
