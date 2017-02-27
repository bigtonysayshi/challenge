package self;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }

    private int findSum(TreeNode node, int current) {
        if (node == null) return 0;
        current = current*10 + node.val;
        if (node.left == null && node.right == null) return current;
        return findSum(node.left, current) + findSum(node.right, current);
    }

}
