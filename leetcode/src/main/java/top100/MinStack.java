package top100;

import java.util.Stack;

/**
 * 实现最小栈
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(-10);
        minStack.push(14);
        minStack.push(-20);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483648);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }

    Stack<Integer> helper;
    Stack<Integer> stack;


    public MinStack() {
        this.stack = new Stack<>();
        this.helper = new Stack<>();
    }

    public void push(int val) {
        if(helper.isEmpty()){
            helper.push(val);
        }else {
            //核心在这里，不要记录全局min，因为全局min可能会被pop出去，这个时候还要做全局min的更新
            helper.push(Math.min(helper.peek(),val));
        }

        stack.push(val);
    }

    public void pop() {
        helper.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
