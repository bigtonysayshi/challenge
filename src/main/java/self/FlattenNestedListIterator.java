package self;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */
public class FlattenNestedListIterator {
    private Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushToStack(nestedList);
    }

    private void pushToStack(List<NestedInteger> nestedList) {
        Stack<NestedInteger> tmpStack = new Stack<>();
        for (NestedInteger nestedInteger : nestedList) {
            tmpStack.push(nestedInteger);
        }
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }

//    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

//    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushToStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
}
