package priv.lyb.study.leecode;

import org.junit.Test;

/**
 * @author LiuYingBo 2021/01/08 00:09
 */
public class Solution7 {
    public int reverse(int x) {
        int xx = Math.abs(x);
        char[] charArray = String.valueOf(xx).toCharArray();
        String isNegative = "";
        int len;
        if (charArray.length % 2 == 0) {
            len = charArray.length / 2;
        } else {
            len = (int) (charArray.length / 2);
        }
        char ca;
        for (int i = 0; i < len; i++) {
            ca = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = ca;
        }
        try {
            if (x < 0) {
                return Integer.valueOf("-" + new String(charArray));
            } else {
                return Integer.valueOf(new String(charArray));
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Test
    public void fun() {
        System.out.println(reverse(1231233299));
    }
}
