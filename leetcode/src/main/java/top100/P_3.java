package top100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 求字符串最长不重复子串长度
 */
public class P_3 {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || "".equals(s)) {
            return 0;
        }
        Map<Character,Integer> windows=new HashMap<>();
        int max = 1;
        int left=0;
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (windows.containsKey(character)) {
                left=Math.max(windows.get(character)+1,left);
            }
            windows.put(character,i);
            max = Math.max(i- left+1 , max);
        }
        return max;

    }


}
