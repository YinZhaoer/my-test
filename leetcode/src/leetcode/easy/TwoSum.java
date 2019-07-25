package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyin
 * @Description TODO
 * @date 2019-06-13 11:22
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums={ 2, 7, 11, 15};
        int target=9;
        int[] res=twoSum(nums,target);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
    //使用map存贮数值和下标，相较暴力双层循环，时间复杂度从O(n2)变为O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length-1;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int num=target-nums[i];
            if(map.containsKey(num)&&map.get(num)!=i)
                return new int[]{i,map.get(num)};
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
