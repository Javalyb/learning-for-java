package priv.lyb.agent;

/**
 * @author LiuYingBo 2021/1/3 下午4:57
 */
class Aodi implements Car {
    @Override
    public void engine() {
        System.out.println("engine");
    }

    @Override
    public void territory() {
        System.out.println("territory");
    }

    @Override
    public void electric() {
        System.out.println("Electric");
    }
}
