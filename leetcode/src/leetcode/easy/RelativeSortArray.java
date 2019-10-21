package leetcode.easy;

/**
 * Author: ZhaoYin
 * Created with IntelliJ IDEA
 * Description: 1122
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(relativeSortArray(arr1, arr2));

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length2 = arr2.length;
        int length1 = arr1.length;
        int min = arr2[0];
        int max = min;
        for (int i = 0; i < length2; i++) {
            int value = arr2[i];
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        int[] lastIndex = new int[max - min + 1];
        //构建bitmap记录
        for (int i = 0; i < length2; i++) {
            lastIndex[arr2[i]] = i - 1;
        }
        //每出现一次就将序号数组的最后序号+1
        for (int i = 0; i < length1; i++) {
            int value = arr1[i];
            if (value >= min && value <= max) {
                lastIndex[value]++;
            } else {

            }
        }
        //根据序号数组构建排序完成后的结果
        for (int j = 0; j < lastIndex.length; j++) {
            int times=arr2[j];
        }
    }
}
