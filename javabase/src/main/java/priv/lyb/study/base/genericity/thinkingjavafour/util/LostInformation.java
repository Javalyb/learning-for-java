package priv.lyb.study.base.genericity.thinkingjavafour.util;

import java.util.*;

/**
 * @author LiuYingBo 2021/01/13 19:54
 */
class Freb{}
class Fnorkle{}
class Quark<Q>{}
class Particle<POSITION,MOMENTUM>{}

//类型擦除
public class LostInformation {
    public static void main(String[] args) {
        List<Freb> a = new ArrayList<>();
        Quark<Freb> b = new Quark<>();
        Map<Freb,Quark<Freb>> c = new HashMap<>();
        Particle<Freb,Fnorkle> d = new Particle<>();

        String e = new String("a");
        System.out.println(Arrays.toString(e.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(a.getClass().getTypeParameters()));

    }
}
