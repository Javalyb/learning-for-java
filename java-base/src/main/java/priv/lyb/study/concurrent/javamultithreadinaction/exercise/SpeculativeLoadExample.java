package priv.lyb.study.concurrent.javamultithreadinaction.exercise;

/**
 * @author LiuYingBo 2021/02/03 19:14
 */
public class SpeculativeLoadExample {
    private boolean ready = false;
    private int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    private void writer() {
        int[] newData = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < newData.length; i++) {
            newData[i] = newData[i] - i;
        }
        data = newData;
        ready = true;
    }

    public int reader() {
        int sum = 0;
        int[] snapshot;
        if (ready) {
            snapshot = data;
            for (int i = 0; i < snapshot.length; i++) {
                sum += snapshot[i];
            }
        }

        return sum;
    }
}
