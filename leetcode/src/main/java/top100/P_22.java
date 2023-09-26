package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class P_22 {

    public static void main(String[] args) {


    }

    public static List<String> generateParenthesis(int n){
        if(n==0){
            return new ArrayList<>();
        }
        List<String> res=new ArrayList<>();
        dfs(n,n,"",res);
        return res;
    }

    public static void dfs(int left,int right,String s,List<String> res){
        if(left==0&&right==0){
            res.add(s);
            return;
        }
        if(left>right){
            return;
        }
        if(left>0){
            dfs(left-1,right,s+"(",res);
        }
        if(right>0){
            dfs(left,right-1,s+")",res);
        }
    }





}
