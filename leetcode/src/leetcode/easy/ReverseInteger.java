package leetcode.easy;

import java.util.Stack;

/**
 * @author zhaoyin
 * @Description TODO
 * @date 2019-06-13 11:33
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Integer x = 1534236469;
        System.out.println(reverse(x));

    }

    //转换为字符串反转问题，使用堆栈性质即可
    public static int reverse(int x) {
        Integer y = x;
        String[] str = y.toString().split("");
        Stack<String> stack = new Stack();
        for (String s : str) {
            stack.push(s);
        }
        String res = new String();
        while (!stack.empty()) {
            res += stack.pop();
        }
        if (x >= 0) {
            if (Long.valueOf(res) > Math.pow(2, 31) - 1) {
                return 0;
            }
            return Integer.valueOf(res);
        } else {
            if (Long.valueOf(res.substring(0, res.length() - 1)) * -1 < -Math.pow(2, 31))
                return 0;
            return Integer.valueOf(res.substring(0, res.length() - 1)) * -1;
        }


    }
}
