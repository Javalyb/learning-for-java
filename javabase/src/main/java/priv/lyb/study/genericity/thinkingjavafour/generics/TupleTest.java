package priv.lyb.study.genericity.thinkingjavafour.generics;

import priv.lyb.study.genericity.thinkingjavafour.util.FourTuple;
import priv.lyb.study.genericity.thinkingjavafour.util.ThreeTuple;
import priv.lyb.study.genericity.thinkingjavafour.util.TwoTuple;

/**
 * @author LiuYingBo 2021/01/13 16:02
 */
class Amphibian {
}

class Vehicle {
}

public class TupleTest {
    static TwoTuple<Amphibian, Integer> fun1() {
        return new TwoTuple<Amphibian, Integer>(new Amphibian(), 1);
    }

    static ThreeTuple<Vehicle, String, Integer> fun2() {
        return new ThreeTuple<Vehicle, String, Integer>(new Vehicle(), "a", 1);
    }

    static FourTuple<Amphibian, Vehicle, String, Integer> fun3(){
        return new FourTuple<Amphibian, Vehicle, String, Integer>(new Amphibian(),new Vehicle(),"",1);
    }

    public static void main(String[] args) {
        TwoTuple<Amphibian, Integer> a= fun1();
        System.out.println(a.toString());

        ThreeTuple<Vehicle, String, Integer> b = fun2();
        System.out.println(b.toString());

        FourTuple<Amphibian, Vehicle, String, Integer> c = fun3();
        System.out.println(c.toString());
    }
}
