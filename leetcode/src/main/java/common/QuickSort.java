package common;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start;
        int j = end;
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
            quickSort(nums, i + 1, end);
            quickSort(nums, start, i - 1);
        }


    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
