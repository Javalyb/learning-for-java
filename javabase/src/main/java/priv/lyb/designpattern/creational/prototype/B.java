package priv.lyb.designpattern.creational.prototype;

import lombok.Data;

/**
 * @author Liuyingbo 2021/1/2
 */
@Data
public class B {
    B(String bb) {
        this.bb = bb;
    }

    private String bb;
}
