package top100;

import java.util.*;

/**
 * 三数之和
 */
public class P_007 {
    public static void main(String[] args) {
        int [] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> filter=new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            if (num > 0) {
                return res;
            }
            while (leftIndex < rightIndex) {
                int numLeft = nums[leftIndex];
                int numRight = nums[rightIndex];
                int sum = num + numLeft + numRight;
                if (sum > 0) {
                    rightIndex--;
                } else if (sum < 0) {
                    leftIndex++;
                } else {
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(num);
                    subRes.add(numLeft);
                    subRes.add(numRight);
                    if(!filter.contains(num+"_"+numLeft+"_"+numRight)){
                        filter.add(num+"_"+numLeft+"_"+numRight);
                        res.add(subRes);
                    }

                    leftIndex++;
                    rightIndex--;
                }
            }
        }
        return res;


    }
}
