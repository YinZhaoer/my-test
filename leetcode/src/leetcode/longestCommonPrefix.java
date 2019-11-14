package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ZhaoYin
 * @version: 2019/11/14
 * @description: 第14题, 字符串的最长公共前缀
 */
public class longestCommonPrefix {
    //todo zy 待优化，通过时间太久了，目前是使用set，通过v+index的方式对数值进行唯一标注
    public static void main(String[] args) {
        String[] strs = {"abcc", "abcc","abcb"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        Set<String> countSet = new HashSet<String>();
        int minLength = getMinLength(strs);
        int count = 0;
        for (int i = 0; i < minLength; i++) {
            countSet.add(String.valueOf(strs[0].charAt(i))+i);
            int beforeCount = countSet.size();
            for (int m = 1; m < strs.length; m++) {
                countSet.add(String.valueOf(strs[m].charAt(i))+i);
            }
            int afterCount = countSet.size();
            if (afterCount > beforeCount ) {
                return strs[0].substring(0, count);
            }
            count++;
        }
        if(count==0){
            return "";
        }else {
            return strs[0].substring(0, count);
        }

    }


    public static int getMinLength(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            int length = strs[i].length();
            if (length < min) {
                min = length;
            }
        }
        return min;
    }


}
