package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        while (root != null && (root.left != null || root.right != null)) {
            results.add(collectLeaves(root));
        }
        if (root != null) {
            List<Integer> rootVal = new ArrayList<>();
            rootVal.add(root.val);
            results.add(rootVal);
            root = null;
        }
        return results;
    }

    private List<Integer> collectLeaves(TreeNode node) {
        List<Integer> leaves = new ArrayList<>();
        if (node.left != null) {
            if (isLeaf(node.left)) {
                leaves.add(node.left.val);
                node.left = null;
            } else {
                leaves.addAll(collectLeaves(node.left));
            }
        }
        if (node.right != null) {
            if (isLeaf(node.right)) {
                leaves.add(node.right.val);
                node.right = null;
            } else {
                leaves.addAll(collectLeaves(node.right));
            }
        }
        return leaves;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
