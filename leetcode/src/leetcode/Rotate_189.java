package leetcode;

import java.util.Stack;

public class Rotate_189 {
    /**
     * 问题的关键是找到规律，全部反转然后反转后n-k个元素就能达到效果
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public static void reverse(int [] nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }


}


