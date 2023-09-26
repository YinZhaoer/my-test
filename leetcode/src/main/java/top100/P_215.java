package top100;

/**
 * 数组中第K大的元素
 */
public class P_215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 3;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int index = fastChoose(nums, 0, nums.length - 1);
        int start = 0;
        int end = nums.length - 1;
        while (index != nums.length - k) {
            if (index > nums.length - k) {
                index = fastChoose(nums, start, index - 1);
            } else {
                index = fastChoose(nums, index + 1, end);
            }
        }
        return nums[index];
    }

    public static int fastChoose(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int base = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= base) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
            while (i < j && nums[i] <= base) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
