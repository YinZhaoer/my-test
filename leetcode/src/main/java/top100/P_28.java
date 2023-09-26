package top100;

import java.util.Objects;

/**
 * 第一个字符串包含下标
 */
public class P_28 {
    public static void main(String[] args) {
        String haystack="aabaabbbaabbbbabaaab";
        String needle="abaa";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            int p=i;
            int q=0;
            while (p<haystack.length()){
                Character hStr=haystack.charAt(p);
                Character nStr=needle.charAt(q);
                if(hStr.equals(nStr)){
                    q++;
                }else {
                    break;
                }
                if(q==needle.length()){
                    return p-q+1;
                }
                p++;
            }
        }
        return -1;


    }
}
