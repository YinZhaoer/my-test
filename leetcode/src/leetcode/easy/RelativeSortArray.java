package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author: ZhaoYin
 * Created with IntelliJ IDEA
 * Description: 1122;核心在于使用bitmap进行计数排序
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(relativeSortArray(arr1, arr2));

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length2 = arr2.length;
        int length1 = arr1.length;
        int index = 0;
        int[] bitMap = new int[1001];
        int[] res = new int[length1];
        //构建bitmap记录,并筛查不在arr2中的arr1元素
        for (int i = 0; i < length1; i++) {
            bitMap[arr1[i]]++;

        }
        //根据arr2给出的顺序排序
        for (int i = 0; i < length2; i++) {
            int value = arr2[i];
            int times = bitMap[value];
            for (int j = 0; j < times; j++) {
                res[index] = value;
                index++;
                bitMap[value]--;
            }

        }
        List<Integer> restValues = new ArrayList();
        for (int i = 0; i < 1001; i++) {
            int restValue = bitMap[i];
            if(restValue!=0){
                for(int j=0;j<restValue;j++){
                    restValues.add(i);
                }
            }

        }
        Collections.sort(restValues);
        for (int i = 0; i < restValues.size(); i++) {
            res[index] = restValues.get(i);
            index++;
        }
        return res;
    }
}

