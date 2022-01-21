package priv.lyb.study.base.enumkey;

/**
 * @author LiuYingBo 2021/01/15 21:41
 */
interface B{

}
enum Search{
    HITHER, YOU
}
enum A implements B{

}
public class UpcaseEnum {
    public static void main(String[] args) {
        Enum<?> c = Search.HITHER;
        for (Enum<?> enumConstant : c.getClass().getEnumConstants()) {
            System.out.println(enumConstant);
        }

        Class<Integer> intClass = Integer.class;
        for (Class enumConstant : intClass.getClass().getEnumConstants()) {
            System.out.println(enumConstant);
        }
    }
}
