package self;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        checkPopStack();
        popStack.pop();
    }

    // Get the front element.
    public int peek() {
        checkPopStack();
        return popStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return popStack.empty() && pushStack.empty();
    }

    private void checkPopStack() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
