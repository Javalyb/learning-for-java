package priv.lyb.study.base.rtti;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/26 21:05
 */
public class Pets {

    public static final PetCreator PET_CREATOR = new LiteralPetCreator();

    public static Pet get(){
        return PET_CREATOR.get();
    }

    public static Pet[] array(int size){
        Pet[] arr = new Pet[size];
        for (int i = 0; i < size; i++) {
            arr[i]=PET_CREATOR.get();
        }
        return arr;
    }

    public static List<Pet> list(int size){
        return Arrays.asList(array(size));
    }

    public static Stream<Pet> stream(){
        return Stream.generate(PET_CREATOR);
    }
}
