package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 长度最小子数组
 */
public class P_209 {
    public static void main(String[] args) {
        int [] nums={5,1,3,5,10,7,4,9,2,8};
        int target=15;
        System.out.println(minSubArrayLen(target,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        List<Integer> list=new ArrayList<>();
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            sum=sum+nums[i];
            if(sum<target){
                continue;
            }
           while (sum>=target) {
               min = Math.min(min, list.size());
               sum=sum-list.get(0);
               list.remove(0);
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
