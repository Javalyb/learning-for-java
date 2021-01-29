package priv.lyb.study.designpattern.creational.prototype;


import java.io.Serializable;

/**
 * @author LiuYingBo 2021/01/28 22:22
 */
public class C implements Serializable {
    private static final long serialVersionUID = 7898333727535277027L;

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    private D d;
}
