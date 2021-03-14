package priv.lyb.study.base.rtti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author LiuYingBo 2021/01/26 19:48
 */
class Individual {
    Individual() {
        super();
    }

    Individual(String name) {
        System.out.println(name);
    }
}

class Person extends Individual {
    Person() {
        super();
    }

    Person(String name) {
        super(name);
    }
}

class Pet extends Individual {
    Pet() {
        super();
    }

    Pet(String name) {
        super(name);
    }
}

class Dog extends Pet {
    Dog() {
        super();
    }

    Dog(String name) {
        super(name);
    }
}

class Mutt extends Dog {
    Mutt() {
    }

    Mutt(String name) {
        super(name);
    }
}

class Pug extends Dog {
    Pug() {
        super();
    }

    Pug(String name) {
        super(name);
    }
}

class Cat extends Pet {
    Cat() {
        super();
    }

    Cat(String name) {
        super(name);
    }
}

class EgyptianMau extends Cat {
    EgyptianMau() {
        super();
    }

    EgyptianMau(String name) {
        super(name);
    }
}

class Manx extends Cat {
    Manx() {
        super();
    }

    Manx(String name) {
        super(name);
    }
}

class Cymric extends Manx {
    Cymric() {
        super();
    }

    Cymric(String name) {
        super(name);
    }
}

class Rodent extends Pet {
    Rodent() {
        super();
    }

    Rodent(String name) {
        super(name);
    }
}

class Rat extends Rodent {
    Rat() {
        super();
    }

    Rat(String name) {
        super(name);
    }
}

class Mouse extends Rodent {
    Mouse() {
        super();
    }

    Mouse(String name) {
        super(name);
    }
}

class Hamster extends Rodent {
    Hamster() {
        super();
    }

    Hamster(String name) {
        super(name);
    }
}

abstract class PetCreator implements Supplier<Pet> {
    private Random random = new Random(47);

    abstract List<Class<? extends Pet>> typeOf();

    @Override
    public Pet get() {
        int n = random.nextInt(typeOf().size());
        try {
            return typeOf().get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "priv.lyb.study.base.rtti.Mutt",
            "priv.lyb.study.base.rtti.Pug",
            "priv.lyb.study.base.rtti.EgyptianMau",
            "priv.lyb.study.base.rtti.Manx",
            "priv.lyb.study.base.rtti.Cymric",
            "priv.lyb.study.base.rtti.Rat",
            "priv.lyb.study.base.rtti.Mouse",
            "priv.lyb.study.base.rtti.Hamster"
    };

    static {
        loader();
    }

    private static void loader() {
        try {
            for (String typeName : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(typeName));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    List<Class<? extends Pet>> typeOf() {
        return types;
    }
}

public class PetCount {
    static class Counter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = this.get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, ++quantity);
            }
        }
    }

    static void countPets(PetCreator creator){
        Counter counter = new Counter();
        try {
            for (Class<? extends Pet> aClass : creator.typeOf()) {
                System.out.println("Class SimpleName "+aClass.getClass().getSimpleName());
                if(aClass.newInstance() instanceof Pet){
                    counter.count("Pet");
                }
                if(aClass.newInstance() instanceof Dog){
                    counter.count("Dog");
                }
                if(aClass.newInstance() instanceof Mutt){
                    counter.count("Mutt");
                }
                if(aClass.newInstance() instanceof Pug){
                    counter.count("Pug");
                }
                if(aClass.newInstance() instanceof Cat){
                    counter.count("Cat");
                }
                if(aClass.newInstance() instanceof EgyptianMau){
                    counter.count("EgyptianMau");
                }
                if(aClass.newInstance() instanceof Manx){
                    counter.count("Manx");
                }
                if(aClass.newInstance() instanceof Cymric){
                    counter.count("Cymric");
                }
                if(aClass.newInstance() instanceof Rodent){
                    counter.count("Rodent");
                }
                if(aClass.newInstance() instanceof Rat){
                    counter.count("Rat");
                }
                if(aClass.newInstance() instanceof Mouse){
                    counter.count("Mouse");
                }
                if(aClass.newInstance() instanceof Hamster){
                    counter.count("Hamster");
                }
            }
            System.out.println();
            System.out.println(counter);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
