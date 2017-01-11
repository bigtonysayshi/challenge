package self;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

    // Recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        return root1.val == root2.val &&
                isMirror(root1.left, root2.right) &&
                isMirror(root1.right, root2.left);
    }

    // Iterative
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root.left);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.add(root.right);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if ((node1 == null || node2 == null)) {
                if (node1 != node2) return false;
            } else {
                if (node1.val != node2.val) return false;
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.right);
                queue2.add(node2.left);
            }
        }
        return true;
    }
}
