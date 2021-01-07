package priv.lyb.study.designpattern.creational.prototype;

import lombok.Data;

/**
 * @author Liuyingbo 2021/1/2
 */
@Data
public class A implements Cloneable {
    private String a;
    private B b;

    public A clone() {
        try {
            return (A) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
