package priv.lyb.study.designpattern.creational.prototype;

/**
 * @author Liuyingbo 2021/1/2
 */
public class B implements Cloneable{
    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    private String bb;

    private int cc;

    B(String bb,int cc) {
        this.bb = bb;
        this.cc = cc;
    }

    public B clone(){
        B b = null;
        try {
            b = (B) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }
}
