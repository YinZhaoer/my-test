package leetcode.medium.divideandconquer;

/**
 * @author zhaoyin
 * @Description 求出未排序数组的第K大个数
 * @date 2019-06-24 10:12
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int k = 2;
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, k));

    }

    public static int findKthLargest(int[] nums, int k) {
       quickSort(nums,0,nums.length-1);
       return nums[k-1];

    }
    //使用快排，复杂度为O(nlogn)
    public static void quickSort(int[] nums,int start,int end){
        if(start>end)
            return;
        int position=divide(nums,0,end);
        quickSort(nums,start,position-1);
        quickSort(nums,position+1,end);
    }

    public static int divide(int[] nums, int start, int end) {
        int base = nums[end];
        while (start < end) {
            while (start<end&&nums[start] >= base)
                start++;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
            }
            while (start<end&&nums[end] <= base)
                end--;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
            }
        }
        return end;
    }


    //先排序后取值，O(n2)
//    public static int findKthLargest(int[] nums, int k) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] < nums[j]) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
//        return nums[k - 1];
//
//    }
}
