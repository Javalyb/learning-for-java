package priv.lyb.study.designpattern.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author LiuYingBo 2021/01/28 22:21
 */
public class Test3 {
    public static void main(String[] args) {
        C c1 = new C();
        c1.setD(new D());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
            out.writeObject(c1);

            ObjectInputStream oi = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            C c2 = (C) oi.readObject();

            System.out.println(c1 == c2);
            System.out.println(c1.getD() == c2.getD());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
