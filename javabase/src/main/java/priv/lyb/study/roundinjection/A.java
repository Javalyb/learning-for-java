package priv.lyb.study.roundinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author LiuYingBo 2021/1/3 下午10:45
 */
@Component
@Scope("prototype")
public class A {
    @Autowired
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

}
