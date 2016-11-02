package self;

/**
 * Invert a binary tree.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftInverted = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = leftInverted;
        return root;
    }
}
