package priv.lyb.study.agent;

/**
 * @author LiuYingBo 2021/1/3 下午4:58
 */
public class AgentCar {
    private static Car car;

    public AgentCar(Car car) {
        this.car = car;
    }

    void engine() {
        System.out.println("agent start");
        car.engine();
        System.out.println("agent end");
    }

    void territory() {
        System.out.println("agent start");
        car.engine();
        System.out.println("agent end");
    }

}
