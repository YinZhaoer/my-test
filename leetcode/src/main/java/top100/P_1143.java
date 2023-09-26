package top100;

import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长公共子序列
 */
public class P_1143 {

    public static void main(String[] args) {
        String s1="abcde";
        String s2="ace";
        System.out.println(longestCommonSubsequence(s1,s2));
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }
}
