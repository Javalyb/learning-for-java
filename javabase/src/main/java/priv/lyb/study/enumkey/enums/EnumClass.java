package priv.lyb.study.enumkey.enums;

/**
 * @author LiuYingBo 2021/01/15 18:44
 */
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery value : Shrubbery.values()) {
            System.out.println("value.ordinal():" + value.ordinal());
            System.out.println("value.compareTo(Shrubbery.CRAWLING):" + value.compareTo(Shrubbery.CRAWLING));
            System.out.println("value.equals(Shrubbery.CRAWLING):" + value.equals(Shrubbery.CRAWLING));
            System.out.println("value==Shrubbery.CRAWLING:" + (value == Shrubbery.CRAWLING));
            System.out.println("value.getDeclaringClass():" + value.getDeclaringClass());
            System.out.println("value.name():" + value.name());
            System.out.println("------------------------------");
        }

        for (String s : "GROUND,CRAWLING,HANGING".split(",")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}
