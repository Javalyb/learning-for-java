package priv.lyb.roundinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author LiuYingBo 2021/1/3 下午10:45
 */
@Component
@Scope("prototype")
public class B implements BBase {
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Autowired
    private A a;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
