package top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除数组重复项
 */
public class P_26 {

    public static void main(String[] args) {
        int[] nums={1,2,2,2,3,4};
        System.out.println(removeDuplicates(nums));
    }


    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int p=0;
        int q=1;
        while (q<nums.length){
           if(nums[p]!=nums[q]){
               nums[++p]=nums[q];
           }
           q++;
        }
        return p+1;
    }


}
