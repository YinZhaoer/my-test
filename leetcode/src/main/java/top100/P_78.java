package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 求子集
 * dp[i] = dp[i - 1] + collections(i)
 */
public class P_78 {



    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size=res.size();
            for(int j=0;j<size;j++){
                List<Integer> newList = new ArrayList<>(res.get(j));// 拷贝所有子集
                newList.add(nums[i]); // 向拷贝的子集中加入当前数形成新的子集
                res.add(newList);
            }
        }
        return res;
    }

    public static void main(String[] args) {



    }
}
