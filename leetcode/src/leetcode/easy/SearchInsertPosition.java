package leetcode.easy;

/**
 * @author zhaoyin
 * @Description TODO
 * @date 2019-06-14 9:48
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;
        System.out.println(searchInsert(nums, target));

    }

    //因为是有序数组所以使用二分查找,注意边界情况，直接取0和right+1,注意多种边界情况
    public static int searchInsert(int[] nums, int target) {
        int flag=0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (target <= nums[left]) return left;
            if (target > nums[right]) return right+1;
            int middle = (left + right) / 2;
            if (target == nums[middle]) return middle;
            if (target > nums[middle]) {
                flag=0;
                left = middle + 1;
            } else {
                flag=1;
                right = middle - 1;
            }
        }
        return flag==0?left:left+1;
    }
}
