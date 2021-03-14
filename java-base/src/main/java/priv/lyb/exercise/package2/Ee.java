package priv.lyb.exercise.package2;

import priv.lyb.exercise.package1.B;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 18:35 2021/02/13
 */
public abstract class Ee implements B{
    Ee(){
        System.out.println("Ee");
        priv.lyb.study.jdk8new.interfacefunction.A aa = new priv.lyb.study.jdk8new.interfacefunction.A(){
            @Override
            public void defaultFunA(String a) {
                System.out.println("defaultFunA");
            }

            @Override
            public void defaultFunB(String a) {
                System.out.println("defaultFunB");
            }

            @Override
            public void fun() {
                System.out.println("fun");
            }
        };
        aa.defaultFunA("aaa");
        aa.defaultFunB("bbb");
        aa.fun();
    }

    public static void main(String[] args) {
        new Ee(){
            @Override
            public int b() {
                return 0;
            }

            @Override
            public void a() {

            }

            @Override
            public void a1() {

            }
        };
    }
}
