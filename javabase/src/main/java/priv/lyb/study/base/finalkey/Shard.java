package priv.lyb.study.base.finalkey;

/**
 * @author LiuYingBo 2021/01/20 18:01
 */
public class Shard {
    private static long counter = 0;
    private final long id = counter++;

    Shard() {
        System.out.println("created Shard " + id);
    }

    public static void main(String[] args) {
        Shard shard = new Shard();
        Composing[] arr = {
                new Composing(),
                new Composing()
        };
    }

//    @Override
//    public String toString() {
//        return id + "";
//    }
}

