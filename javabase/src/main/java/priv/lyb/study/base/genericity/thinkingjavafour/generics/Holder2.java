package priv.lyb.study.base.genericity.thinkingjavafour.generics;

/**
 * @author LiuYingBo 2021/01/13 15:30
 */
public class Holder2 {
    private Object object;

    public Holder2(Object object) {
        this.object = object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return this.object;
    }

    public static void main(String[] args) {
        Holder2 a = new Holder2("a");
        String b = (String) a.getObject();
        System.out.println(b);

        a.setObject(new Automobile());
        Automobile c = (Automobile) a.getObject();
        System.out.println(c);
    }
}
