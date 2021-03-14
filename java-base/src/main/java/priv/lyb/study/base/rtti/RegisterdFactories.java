package priv.lyb.study.base.rtti;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/27 00:32
 */

class Part implements Supplier<Part> {
    static List<Supplier<? extends Part>> prototypes =
            Arrays.asList(
                    new FuelFilter(),
                    new AirFilter(),
                    new CabinAirFilter(),
                    new OilFilter(),
                    new FanBelt(),
                    new PowerSteeringBelt(),
                    new GeneratorBelt()
            );

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    private Random random = new Random(47);
    @Override
    public Part get() {
        return prototypes.get(random.nextInt(prototypes.size())).get();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
    @Override
    public Part get() {
        return new FuelFilter();
    }
}

class AirFilter extends Filter {
    @Override
    public Part get() {
        return new AirFilter();
    }
}

class CabinAirFilter extends Filter {
    @Override
    public Part get() {
        return new CabinAirFilter();
    }
}

class OilFilter extends Filter {
    @Override
    public Part get() {
        return new OilFilter();
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    @Override
    public Part get() {
        return new FanBelt();
    }
}

class GeneratorBelt extends Belt {
    @Override
    public Part get() {
        return new GeneratorBelt();
    }
}

class PowerSteeringBelt extends Belt {
    @Override
    public Part get() {
        return new PowerSteeringBelt();
    }
}


public class RegisterdFactories {
    public static void main(String[] args) {
        Stream.generate(new Part())
                .limit(3)
                .forEach(System.out::println);
    }
}
