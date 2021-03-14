package priv.lyb.study.base.exception;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author LiuYingBo 2021/01/24 21:41
 */
class Reporter implements Closeable {
    String name = this.getClass().getSimpleName();

    Reporter() {
        System.out.println("Creating " + name);
    }

    public void close() {
        System.out.println("Closeing " + name);
    }
}

class First extends Reporter {
}

class Second extends Reporter {
}

class Three{}

public class AutoCloseableDetails {
    public static void main(String[] args) {
        try (
                First first = new First();
                Second second = new Second();
        ) {
                Three three = new Three();
        }
    }
}
