package priv.lyb.study.enumkey.enums;

/**
 * @author LiuYingBo 2021/01/15 20:34
 */

enum Signal {
    GREEN, YELLOW, RED,
}

public class TrafficLight {
    Signal signal = Signal.RED;

    public static void main(String[] args) {

        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }

    public void change() {
        switch (signal) {
            case RED: signal = Signal.GREEN;
                break;
            case GREEN: signal = Signal.YELLOW;
                break;
            case YELLOW: signal = Signal.RED;
                break;
            default:signal = Signal.RED;
        }
    }

    @Override
    public String toString() {
        return signal.toString();
    }
}
