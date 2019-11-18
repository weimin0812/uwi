package swordoffer.question05;

import java.util.Stack;

public class Solution {
    // 用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // stack1 push stack
    // stack2 pop stack
    // 变量命名不好

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // ["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
    // 对应输出应该为:1,2,3,4,5

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        solution.push(4);
        System.out.println(solution.pop());
        solution.push(5);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}
