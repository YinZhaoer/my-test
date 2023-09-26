package top100;

import java.util.*;

/**
 * 字符串排列
 * 核心是滑动窗口+字典
 * 对比每个字符的个数
 */
public class P_567 {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if ("".equals(s1) || "".equals(s2)) {
            return false;
        }
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s2Length < s1Length) {
            return false;
        }
        int [] count1=new int[26];
        int [] count2=new int[26];
        for(int i=0;i<s1Length;i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }

        int start=0;
        int end=s1Length-1;
        while (end<s2Length-1){
            if( Arrays.equals(count1,count2)){
                return true;
            }
            char in=s2.charAt(end+1);
            char out=s2.charAt(start);
            if(count2[out-'a']>0){
                count2[out-'a']--;
            }
            count2[in-'a']++;
            start++;
            end++;

        }
        return Arrays.equals(count1,count2);
    }


    /**
     * 写法比较复杂
     * @param s1
     * @param s2
     * @return
     */
    public boolean mapVersion(String s1, String s2) {
        if ("".equals(s1) || "".equals(s2)) {
            return false;
        }
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s2Length < s1Length) {
            return false;
        }
        Map<Character, Integer> count1Map = new HashMap<>();
        Map<Character, Integer> count2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!count1Map.containsKey(s1.charAt(i))) {
                count1Map.put(s1.charAt(i), 1);
            } else {
                count1Map.put(s1.charAt(i), count1Map.get(s1.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            if (count1Map.containsKey(s2.charAt(i))) {
                if (!count2Map.containsKey(s2.charAt(i))) {
                    count2Map.put(s2.charAt(i), 1);
                } else {
                    count2Map.put(s2.charAt(i), count2Map.get(s2.charAt(i)) + 1);
                }

            }

        }
        int start = 0;
        int end = s1Length-1;
        while (end <= s2Length-1) {
            if(count1Map.size()==count2Map.size()){
                boolean flag=true;
                for(Map.Entry<Character,Integer> entry:count1Map.entrySet()){
                    if(count2Map.get(entry.getKey())==null||! Objects.equals(count2Map.get(entry.getKey()), entry.getValue())){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
            if(end==s2Length-1){
                return false;
            }
            Character outCh=s2.charAt(start);
            Character inCh=s2.charAt(end+1);
            if(count2Map.containsKey(outCh)){
                int startChCount=count2Map.get(outCh)-1;
                if(startChCount==0){
                    count2Map.remove(outCh);
                }else {
                    count2Map.put(outCh,startChCount);
                }

            }
            if(count1Map.containsKey(inCh)){
                if(!count2Map.containsKey(inCh)){
                    count2Map.put(inCh,1);
                }else {
                    count2Map.put(inCh,count2Map.get(inCh)+1);
                }

            }
            start++;
            end++;
        }
        return false;
    }
}


