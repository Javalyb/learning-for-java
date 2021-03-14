package priv.lyb.study.base.array;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author LiuYingBo 2021/01/28 15:38
 */
public interface Count {
    final static int SZ = 5;
    void fun1();

    public static void main(String[] args) {
        java.lang.Boolean[] a1 = new java.lang.Boolean[SZ];
//        Arrays.setAll(a1, new Count.Boolean()::get);
        Arrays.setAll(a1, s -> {
            return new Count.Boolean().get(1);
        });
        ArrayShow.show(a1);
    }

    static class Boolean implements Supplier<java.lang.Boolean> {
        private boolean b = true;

        @Override
        public java.lang.Boolean get() {
            return java.lang.Boolean.valueOf(b);
        }

        public java.lang.Boolean get(int n) {
            return get();
        }

        public java.lang.Boolean[] array(int sz) {
            java.lang.Boolean[] result = new java.lang.Boolean[sz];
            Arrays.setAll(result, s -> get());
            return result;
        }


    }
}
