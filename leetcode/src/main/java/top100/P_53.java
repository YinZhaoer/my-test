package top100;

/**
 * 最大子数组和
 */
public class P_53 {

    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }

    public static int maxSubArrayDp(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}
