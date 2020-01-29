package leetcode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/**
 * @author: ZhaoYin
 * @version: 2019/11/19
 * @description: 20题,利用堆栈解法，开括号入栈，闭括号则pop栈顶进行匹配，不能配置则false
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));

    }


    public static boolean isValid(String s) {
        Stack<String> stack=new Stack<>();
        String[] strs=s.split("");
        for(String str:strs){
            if(str.equals("("))
                stack.push(str);
            if(str.equals(")")&&(stack.empty()||!stack.pop().equals("(")))
                return false;
            if(str.equals("{"))
                stack.push(str);
            if(str.equals("}")&&(stack.empty()||!stack.pop().equals("{")))
               return false;
            if(str.equals("["))
                 stack.push(str);
            if(str.equals("]")&&(stack.empty()||!stack.pop().equals("[")))
                return false;
        }
        if(stack.empty())
            return true;

        return false;
    }

}
