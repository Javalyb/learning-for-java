package priv.lyb.study.base.innerclass;

import java.util.Base64;

/**
 * @author LiuYingBo 2021/01/21 16:21
 */
abstract class Base{
    Base(int i){
        System.out.println("Base " + i);
    }
    public abstract void f();
    public abstract void f1();
}
public class AnonymousConstructor {
    public static Base getBase(int i,int c){

        Base base =  new Base(i) {
            {
                System.out.println("初始化");
            }
            @Override
            public void f() {
                System.out.println(i);
            }
            public void f1(){
                System.out.println(c);
            }
        };
        return base;
    }

    public static void main(String[] args) {
        Base base = AnonymousConstructor.getBase(5,10);
        base.f();
        base.f1();
    }
}
