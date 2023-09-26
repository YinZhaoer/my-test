package top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的连续子数组个数
 */
public class P_560 {


    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> preSumMap=new HashMap<>();
        int count=0;
        int preSum=0;
        preSumMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            if(preSumMap.containsKey(preSum-k)){
                count+=preSumMap.get(preSum-k);
            }
            if(preSumMap.containsKey(preSum)){
                preSumMap.put(preSum,preSumMap.get(preSum)+1);
            }else {
                preSumMap.put(preSum,1);
            }
        }
        return count;



    }
}
