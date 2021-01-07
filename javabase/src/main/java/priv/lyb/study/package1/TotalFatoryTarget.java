package priv.lyb.study.package1;

/**
 * @author LiuYingBo 2021/1/3 下午4:40
 */
public class TotalFatoryTarget implements priv.lyb.study.package1.TotalFactory {
    @Override
    public Car createCar() {
        return new priv.lyb.study.package1.CarA();
    }

    @Override
    public Engine createEngine() {
        return new priv.lyb.study.package1.EngineA();
    }
}
