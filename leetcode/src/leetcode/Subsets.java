package leetcode;

import java.util.*;

/**
 * @author: ZhaoYin
 * @version: 2019/11/15
 * @description: 第78题，求解不重复数组的所有去重子集,关键思路在于，每遍历一位，都在原先的结果上add即可。
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> subsets(final int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if (nums.length == 0) {
            return res;
        }
       for(int i=0;i<nums.length;i++){
           //核心代码
           List<List<Integer>> subRes=new ArrayList<List<Integer>>();
           for(List<Integer> list:res){
               List<Integer> temp=new ArrayList<>();
               temp.addAll(list);
               temp.add(nums[i]);
               subRes.add(temp);
           }
           res.addAll(subRes);

       }
        return res;

    }
}
