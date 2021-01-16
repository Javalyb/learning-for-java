package priv.lyb.study.enumkey.enums;

import java.util.stream.Stream;

/**
 * @author LiuYingBo 2021/01/15 20:18
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        Stream.of(values()).forEach(System.out::println);
    }
}
