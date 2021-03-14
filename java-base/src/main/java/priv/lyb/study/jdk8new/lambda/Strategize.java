package priv.lyb.study.jdk8new.lambda;

/**
 * @author LiuYingBo 2021/01/22 20:31
 */
interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    Strategy strategy;
    String msg;

    Strategize(String msg) {
        strategy = new Soft();
        this.msg = msg;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg1 -> msg1.substring(0, 5),
                Unrelated::twice
        };
        Strategize strategize = new Strategize("Hello there");
        strategize.communicate();
        for (Strategy strategy : strategies) {
            strategize.changeStrategy(strategy);
            strategize.communicate();
        }
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
