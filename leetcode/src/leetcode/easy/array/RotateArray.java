package leetcode.easy.array;

/**
 * @author zhaoyin
 * @Description 按照K给定位置截取array，并将截取部分放置在数组最前面
 * @date 2019-06-17 10:55
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=4;
        rotate(nums,k);
        for(int i:nums){
            System.out.print(i);
        }

    }

    //使用空间复杂度为O(1)的解法,先反转整个array，然后分别反转前k个array和后面的array
    public static void rotate(int[] nums, int k) {
            k%=nums.length;
            reverse(nums,0,nums.length-1);
            reverse(nums,0,k-1);
            reverse(nums,k,nums.length-1);


    }

    public static void reverse(int[] nums,int start,int end){
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
