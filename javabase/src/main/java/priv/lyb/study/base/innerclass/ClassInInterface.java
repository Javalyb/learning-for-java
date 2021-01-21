//接口内部类;
package priv.lyb.study.base.innerclass;

/**
 * @author LiuYingBo 2021/01/21 16:44
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface{
        @Override
        public void howdy() {
            System.out.println("howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
