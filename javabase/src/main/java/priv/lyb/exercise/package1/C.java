package priv.lyb.exercise.package1;

/**
 * @author LiuYingBo 2021/02/10 22:18
 */
public class C {
    public C(){
        System.out.println("C 初始化");
    }
    int i;
    public void c(){
        C.E ee = new C().new E();
        C.E ee1 = new C.E();
        System.out.println(ee==ee1);
    }

    public class E{
        public E(){
            System.out.println("E 初始化");
        }
    }
}
