import java.util.*;

public class P_1 {

    public static void main(String[] args) {
        int [] nums={1,2,7,9};
        int target=8;
        System.out.print(twoSum(nums,target));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[2];
        }
        Set<Integer> numSet = new HashSet<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numSet.add(num);
            int finalI = i;
            indexMap.compute(num, (k, v) -> {
                if (indexMap.containsKey(num)) {
                    List<Integer> indexSet = indexMap.get(num);
                    indexSet.add(finalI);
                    return indexSet;
                } else {
                    List<Integer> indexList=new ArrayList<>();
                    indexList.add(finalI);
                    return indexList;
                }
            });

        }
        for (Integer num : numSet) {
            int diff = target - num;
            if (numSet.contains(diff)) {
                if (diff != num) {
                    return new int[]{indexMap.get(num).get(0), indexMap.get(diff).get(0)};
                } else {
                    List<Integer> indexList=indexMap.get(num);
                    if(indexList.size()>=2){
                        return new int[]{indexList.get(0),indexList.get(1)};
                    }else {
                        return new int[2];
                    }

                }
            }
        }
        return new int[2];
    }
}
