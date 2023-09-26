package top100.repeat;

import java.util.HashMap;
import java.util.Map;

public class P_3 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s) || s == null) {
            return 0;
        }
        int left = 0;
        int max = 1;
        Map<Character, Integer> characterIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (characterIndexMap.containsKey(character)) {
                //关键case
                left = Math.max(characterIndexMap.get(character)+1,left);
            }
            characterIndexMap.put(character, i);
            max = Math.max(i - left + 1, max);

        }
        return max;
    }


}
