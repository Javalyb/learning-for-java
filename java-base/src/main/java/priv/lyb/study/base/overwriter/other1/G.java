package priv.lyb.study.base.overwriter.other1;

import org.junit.jupiter.api.Test;
import priv.lyb.study.base.overwriter.other2.A;

/**
 * @author LiuYingBo 2021/01/23 00:17
 */
public class G extends A {
    @Override
    public void overWriter(Integer p1, StringBuffer p2) {
        System.out.println("G overWriter");
    }

    @Test
    public void fun(){
        A a1 = new G();


        G g1 = new G();
        g1.overWriter(1,new StringBuffer());

        A a2 = new A();


    }
}
