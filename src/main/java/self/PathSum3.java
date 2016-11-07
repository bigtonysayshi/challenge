package self;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        List<Integer> targets = new ArrayList<Integer>();
        targets.add(sum);
        return pathSumHelper(root, sum, targets);
    }

    private int pathSumHelper(TreeNode node, int sum, final List<Integer> targets) {
        if (node == null) return 0;
        int numPaths = 0;
        List<Integer> newTargets = new ArrayList<Integer>();
        newTargets.add(sum);
        for (int n : targets) {
            if (n == node.val) numPaths++;
            newTargets.add(n - node.val);
        }
        return numPaths + pathSumHelper(node.left, sum, newTargets) +
                pathSumHelper(node.right, sum, newTargets);
    }
}
