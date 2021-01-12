package priv.lyb.study.base.operator;

/**
 * @author LiuYingBo 2021/01/08 13:15
 */
public class Test {
    @org.junit.Test
    public void fun() {
        String a = "s";
        String b = new String("s");
        String c = "s";
        b = b + c;
        String g = a + c;
        System.out.println(a == c);//堆常量池
        System.out.println(a == b);
        System.out.println(b == g);

        String d = "s" + "s";
        String f = "s" + "s";
        StringBuffer stringBuffer = new StringBuffer("s");
        stringBuffer.append("s");
        System.out.println(d == f);
        System.out.println(stringBuffer.toString() == d);

        StringBuilder stringBuilder = new StringBuilder("s");
        stringBuilder.append("s");
        System.out.println(stringBuffer.toString() == stringBuilder.toString());
        System.out.println(stringBuffer.toString().equals(stringBuilder.toString()));
    }
}
