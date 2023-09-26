package top100;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 求最长回文子串
 * todo zy
 */
public class P_5 {
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLen=1;
        int begin=0;

        boolean[][] dp=new boolean[length][length];
        char[] chars=s.toCharArray();

        for(int i=0;i<length;i++){
            dp[i][i]=true;
        }
        for(int j=1;j<length;j++){
            for(int i=0;i<j;i++){
                if(chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i<2){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    begin=i;
                    maxLen=j-i+1;
                }
            }
        }
        return s.substring(begin,maxLen+begin);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
