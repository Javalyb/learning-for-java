package priv.lyb.study.jvm.classload;


import sun.misc.Launcher;

import java.net.URL;

/**
 * @author LiuYingBo 2021/1/5 下午12:23
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void fun() {
        new Children();
        //5 1 10 6 9 2 3 9 7 8
        for (URL url : Launcher.getBootstrapClassPath().getURLs()) {
            System.out.println(url.toExternalForm());
        }
    }
}
