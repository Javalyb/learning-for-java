package priv.lyb.study.base.enumkey.enums;

import java.util.EnumSet;

/**
 * @author LiuYingBo 2021/01/16 11:37
 */
enum AlarmPoints{
    STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3,
    OFFICE4, BATHROOM, UTILITY, KITCHEN;
    AlarmPoints(){
//        System.out.println(this);
    }
}
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> set = EnumSet.noneOf(AlarmPoints.class);
        set.add(AlarmPoints.BATHROOM);
        System.out.println(set);
        set.addAll(EnumSet.of(AlarmPoints.OFFICE1,AlarmPoints.OFFICE2));
        System.out.println(set);
        set=EnumSet.allOf(AlarmPoints.class);
        System.out.println(set);
        set.removeAll(EnumSet.of(AlarmPoints.OFFICE1,AlarmPoints.OFFICE2));
        System.out.println(set);
        set.removeAll(EnumSet.range(AlarmPoints.BATHROOM,AlarmPoints.KITCHEN));
        System.out.println(set);
        set= EnumSet.complementOf(set);
        System.out.println(set);
    }
}
