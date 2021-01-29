package priv.lyb.study.designpattern.creational.prototype;

/**
 * @author LiuYingBo 2021/01/28 21:22
 */
public class Test2 {
    public static void main(String[] args) {
        A a1 = new A();
        a1.setA("a1");
        a1.setB(new B("bb1", 1));
        a1.setC(1);

        A a2 = a1;
        System.out.println("a1==a2 :" + (a1 == a2));

        A a3 = a1.clone();
        System.out.println("a1==a3 :" + (a1 == a3));
        System.out.println("a1.getA()==a3.getA(): " + (a1.getA()==a3.getA()));
        System.out.println("a1.getB()==a3.getB(): " + (a1.getB()==a3.getB()));
        System.out.println("a1.getC()==a3.getC(): "+(a1.getC()==a3.getC()));
    }
}
