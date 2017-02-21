package self;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 */
public class CountUniValueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        return Math.abs(findSubtrees(root));
    }

    private int findSubtrees(TreeNode node) {
        if (node.left == null && node.right == null) return 1;
        int leftCounts = 0, rightCounts = 0;
        boolean uniValue = true;
        if (node.left != null) {
            leftCounts = findSubtrees(node.left);
            if (leftCounts < 0 || node.left.val != node.val) uniValue = false;
        }
        if (node.right != null) {
            rightCounts = findSubtrees(node.right);
            if (rightCounts < 0 || node.right.val != node.val) uniValue = false;
        }
        if (leftCounts == 0 && rightCounts == 0) return 0;
        if (uniValue) {
            return leftCounts + rightCounts + 1;
        } else {
            return -(Math.abs(leftCounts) + Math.abs(rightCounts));
        }
    }
}
