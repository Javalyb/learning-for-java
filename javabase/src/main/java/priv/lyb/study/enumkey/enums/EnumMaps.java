package priv.lyb.study.enumkey.enums;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author LiuYingBo 2021/01/16 20:27
 */
interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.BATHROOM, () -> System.out.println("bathroom"));
        em.put(AlarmPoints.KITCHEN, () -> System.out.println("kitchen"));
        for (Map.Entry<AlarmPoints, Command> alarmPointsCommandEntry : em.entrySet()) {
            System.out.println(alarmPointsCommandEntry.getKey());
            alarmPointsCommandEntry.getValue().action();
        }
        System.out.println("-----------------");

        em.get(AlarmPoints.BATHROOM).action();
        em.get(AlarmPoints.OFFICE1).action();

    }
}
