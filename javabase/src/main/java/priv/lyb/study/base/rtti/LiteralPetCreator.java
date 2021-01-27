package priv.lyb.study.base.rtti;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LiuYingBo 2021/01/26 20:48
 */
public class LiteralPetCreator extends PetCreator {
    static final List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class));

    private static final List<Class<? extends Pet>> TYPES =
            ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class),ALL_TYPES.size());


    @Override
    List<Class<? extends Pet>> typeOf() {
        return TYPES;
    }

    @Override
    public Pet get() {
        return super.get();
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
    }
}
