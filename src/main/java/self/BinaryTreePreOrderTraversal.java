package self;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreOrderTraversal {
    // Iterative
    // Time: O(n) Space: O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.right != null) rightStack.push(curr.right);
            vals.add(curr.val);
            curr = curr.left;
            if (curr == null && !rightStack.empty()) curr = rightStack.pop();
        }
        return vals;
    }

    // Recursive
    // Time: O(n) Space: O(n)
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        traversalHelper(root, vals);
        return vals;
    }

    private void traversalHelper(TreeNode node, List<Integer> vals) {
        if (node != null) {
            vals.add(node.val);
            traversalHelper(node.left, vals);
            traversalHelper(node.right, vals);
        }
    }
}
