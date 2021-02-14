package priv.lyb.exercise.package2;

import priv.lyb.exercise.package1.C;

/**
 * @author LiuYingBo 2021/02/10 22:22
 */
public class D extends C{
    public static void main(String[] args) {
        C c = new C();
    }

    void fun(){
        C.E c = new C.E();
    }

}
