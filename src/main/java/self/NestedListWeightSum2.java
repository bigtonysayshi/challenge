package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Different from the previous question where weight is increasing from root to leaf,
 * now the weight is defined from bottom up.
 * i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 */
public class NestedListWeightSum2 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = depth(nestedList);
        return depthSumHelper(nestedList, depth);
    }

    private int depth(List<NestedInteger> nestedList) {
        int depth = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                depth = Math.max(depth, 1);
            } else {
                depth = Math.max(depth, 1 + depth(nestedInteger.getList()));
            }
        }
        return depth;
    }

    private int depthSumHelper(List<NestedInteger> nestedList, int weight) {
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * weight;
            } else {
                sum += depthSumHelper(nestedInteger.getList(), weight - 1) * weight;
            }
        }
        return sum;
    }

    // solution without getting depth
    public int depthSumInverse2(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
}
