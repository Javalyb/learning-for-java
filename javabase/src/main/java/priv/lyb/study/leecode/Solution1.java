package priv.lyb.study.leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author LiuYingBo 2021/01/08 00:09
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] resultArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resultArr[0] = i;
                    resultArr[1] = j;
                    break;
                }
            }
        }
        return resultArr;
    }

    @Test
    public void fun() {
        int[] nums = {1, 3, 4, 6, 8};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
