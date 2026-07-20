package priv.lyb.study.base.array;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author LiuYingBo 2021/01/28 16:01
 */
public class TestCount {
    public static void main(String[] args) {
        new Supplier<String>(){
            @Override
            public String get() {
                return null;
            }
        };

        String [] str = new String[5];
        for (String s : str) {
            continue;
        }
    }


}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] sum = new int [2];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i==j){
                    continue;
                }else{
                    if(nums[i] + nums[j] == target){
                        System.out.println("数组：" +nums[i] + "," +nums[j]);
                        break;
                    }
                }
            }
        }
        return sum;
    }
}

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeList = new ArrayList<List<Integer>>();
        return threeList;
    }
}

