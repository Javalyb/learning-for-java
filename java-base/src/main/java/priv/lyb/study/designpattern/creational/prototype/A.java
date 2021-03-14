package priv.lyb.study.designpattern.creational.prototype;

/**
 * @author Liuyingbo 2021/1/2
 */

public class A implements Cloneable {
    A(){
        System.out.println("goto A");
    }


    private String a;
    private B b;
    private int c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
//    protected A clone() {
//        try {
//            return (A) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public A clone() {
        A objA = null;
        try {
            objA = (A) super.clone();
            this.b = this.b.clone();
            return objA;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


}
