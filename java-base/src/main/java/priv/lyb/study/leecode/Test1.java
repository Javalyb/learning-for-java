package priv.lyb.study.leecode;

import java.util.*;

/**
* @description: 
* @author: lyb
* @create: 2026-05-31 12:05
**/
public class Test1 {

    public static void main(String[] args) {
       String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
        groupAnagrams1(strs);

        int [] nums = {1,1,1,2,2,3};
        topKFrequent(nums,2);


        int [] nums1 = {-1,0,1,2,-1,-4};
        threeSum1(nums1);
        threeSum(nums1);


        String s = "abba";
        lengthOfLongestSubstring(s);


        ListNode head5 = new ListNode(5,null);
        ListNode head4 = new ListNode(4,head5);
        ListNode head3 = new ListNode(3,head4);
        ListNode head2 = new ListNode(2,head3);
        ListNode head = new ListNode(1,head2);
        reverseList(head);
    }

    //    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();

        outer:
        for(String str : strs){
            List<String> strList = new ArrayList<>();
            for (List<String> strings : list) {
                if(strings.contains(str) && !str.trim().equals("")){
                    continue outer;
                }
            }
            for(String str1 : strs){
                boolean result = true;
                if(!str.equals(str1)){
                    int [] charArr = new int [26];
                    for(char c : str.toCharArray()){
                        charArr[c - 'a']++;
                    }
                    for(char c : str1.toCharArray()){
                        charArr[c - 'a']--;
                        if(charArr[c - 'a'] < 0){
                            result = false;
                        }
                    }
                    if(result){
                        strList.add(str1);
                    }
                }
            }
            strList.add(str);
            list.add(strList);
        }

        System.out.println(list);
        return list;
    }


    //    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public static List<List<String>> groupAnagrams1(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char [] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = Arrays.toString(charArr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);

        }
        System.out.println(new ArrayList<>(map.values()));
        return new ArrayList<>(map.values());
    }



    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    /*示例 1：

    输入：nums = [1,1,1,2,2,3], k = 2

    输出：[1,2]

    示例 2：

    输入：nums = [1], k = 1

    输出：[1]

    示例 3：

    输入：nums = [1,2,1,2,1,2,3,1,3,2], k = 2

    输出：[1,2]*/
    public static int[] topKFrequent(int[] nums, int k) {

        List<String> list = new ArrayList<>();


        Map <String , Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(String.valueOf(num), map.getOrDefault(String.valueOf(num), 0) + 1);
        }

        //map转数组
        int[] result = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // 按value降序
                .limit(k) // 取前几条
                .mapToInt(entry -> Integer.parseInt(entry.getKey()))
                .toArray(); // 转数组


        System.out.println(Arrays.toString(result));
        return result;
    }



    /*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。*/

    /*输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    解释：
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
    不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
    注意，输出的顺序和三元组的顺序并不重要。*/

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> threeList = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                for(int k = 0; k < nums.length; k++){
                    List<Integer>  list = new ArrayList<>();
                    if(i!=j && j!=k && i!=k && nums[i]+nums[j]+nums[k] == 0){
                        Integer [] arr1 = {nums[i],nums[j],nums[k]};
                        Arrays.sort(arr1);
                        String string1 = Arrays.toString(arr1);

                        Boolean bol = false;
                        for (List<Integer> integers : threeList) {
                            Integer [] arr = integers.toArray(new Integer [integers.size()]);
                            Arrays.sort(arr);
                            String string = Arrays.toString(arr);
                            if(string.equals(string1)){
                                bol = true;
                            }
                        }
                        if(!bol){
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            threeList.add(list);
                        }
                    }
                }
            }
        }

        System.out.println(threeList);
        return threeList;
    }


    /*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。*/

    /*输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    解释：
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
    不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
    注意，输出的顺序和三元组的顺序并不重要。*/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // 先排序

        for (int i = 0; i < nums.length; i++) {

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length-1;

            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];

                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                }else{
                    right--;
                }


            }

        }

        return result;
    }



    /*给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。*/

    /*输入: s = "abba"*/

    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            //窗口是否包含key,且重复key的索引位置需要在窗口中
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(s.charAt(right)) + 1;
            }
            map.put(c, right);
            //窗口收缩,需要记住以前的最大值
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);

        return maxLen;

    }


    /*输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1]*/
    public static ListNode reverseList(ListNode head) {



        while (head.next != null) {
            int midVal = head.next.val;
            ListNode midListNode = head.next;

            head.val =  head.next.val;
            head.next = midListNode;


            ListNode temp = head.next.next;



        }


        return head;
    }
}



