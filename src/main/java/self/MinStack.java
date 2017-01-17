package self;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * Design a stack that supports push, pop, top,
 * and retrieving the minimum element in constant time.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = null;
    }

    public void push(int x) {
        if (min == null) {
            min = x;
        } else {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int val = stack.pop();
        if (stack.isEmpty()) {
            min = null;
        } else {
            if (min == val) min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */