package priv.lyb.study.base.exception;

/**
 * @author LiuYingBo 2021/01/24 20:09
 */
class BaseballException extends Exception{}
class Four extends BaseballException{}
class Strike extends BaseballException{}
abstract class Inning{
    Inning() throws BaseballException{}
    void event() throws BaseballException{}
    abstract void atBat() throws Four,Strike;
    void walk(){}
}

class StromExcetion extends Exception{}
class RainedOut extends StromExcetion{}
class PopFoul extends Four{}
interface Storm{
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
    public StormyInning() throws RainedOut,BaseballException{}
    public StormyInning(String s) throws BaseballException{}
    static StormyInning stormyInning;

    @Override
    void atBat() throws Four, Strike {}

    @Override
    public void event() {}

    @Override
    public void rainHard() throws RainedOut {}

    public static void main(String[] args) {
        try {
            stormyInning = new StormyInning();
        } catch (RainedOut | BaseballException rainedOut) {
            rainedOut.printStackTrace();
        }

        try {
            stormyInning = new StormyInning("");
        } catch (BaseballException e) {
            e.printStackTrace();
        }

        try {
            Inning inning = new StormyInning();
        } catch (RainedOut | BaseballException rainedOut) {
            rainedOut.printStackTrace();
        }

        try {
            Storm storm = new StormyInning();
        } catch (RainedOut | BaseballException rainedOut) {
            rainedOut.printStackTrace();
        }
    }
}
