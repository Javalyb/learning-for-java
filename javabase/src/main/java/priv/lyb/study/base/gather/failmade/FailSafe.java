package priv.lyb.study.base.gather.failmade;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author LiuYingBo 2021/01/10 23:40
 */
public class FailSafe {
    @Test
    public void fun() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.add("2");
        copyOnWriteArrayList.add("3");
        for (Iterator<String> iterator = copyOnWriteArrayList.iterator(); iterator.hasNext(); ) {
            String str = iterator.next();
            if ("1".equals(str)) {
                copyOnWriteArrayList.remove(0);
            }
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}
