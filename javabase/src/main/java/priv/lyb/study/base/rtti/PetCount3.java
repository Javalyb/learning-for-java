package priv.lyb.study.base.rtti;


/**
 * @author LiuYingBo 2021/01/26 22:24
 */

public class PetCount3 {
    static void get(){
        LiteralPetCreator.ALL_TYPES.stream()
                    .filter(s -> s.isInstance(new Pet()))
                    .forEach(System.out::println);
    }

    public static void main(String[] args) {
        get();
    }
}
