package priv.lyb.study.base.genericity.thinkingjavafour.exercise;

import com.sun.org.apache.xerces.internal.dom.AttrNSImpl;
import org.junit.jupiter.api.Test;
import org.w3c.dom.TypeInfo;
import priv.lyb.study.base.genericity.thinkingjavafour.generics.Holder3;

/**
 * @author LiuYingBo 2021/01/14 13:55
 */
public class A {
    @Test
    public void fun(){
        Holder3<TypeInfo> holder3 = new Holder3<>(new AttrNSImpl());
        System.out.println(holder3.getT());
    }
}
