//接口内部类;
package priv.lyb.study.base.innerclass;

/**
 * @author LiuYingBo 2021/01/21 16:44
 */
public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {
        public static void main(String[] args) {
            new ClassInInterface.Test().how();
            new ClassInInterface.Test().howdy();
            new Test().howdy();
        }

        public static void how() {
            System.out.println("how");
        }

        @Override
        public void howdy() {
            System.out.println("howdy");
        }
    }
}
