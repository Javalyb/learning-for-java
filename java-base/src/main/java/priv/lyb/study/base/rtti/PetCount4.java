package priv.lyb.study.base.rtti;

/**
 * @author LiuYingBo 2021/01/26 23:12
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        Pets.stream()
                .limit(20)
                .peek(counter::count)
                .forEach(pet -> System.out.println(pet.getClass().getSimpleName()+""));
        System.out.println(counter);
    }
}