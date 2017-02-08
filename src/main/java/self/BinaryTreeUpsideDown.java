package self;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty, flip it upside down
 * and turn it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode parent = root, curr = root.left;
        while (curr.left != null) {
            parent = curr;
            curr = curr.left;
        }
        curr.left = upsideDownBinaryTree(parent.right);
        parent.left = null;
        parent.right = null;
        curr.right = upsideDownBinaryTree(root);
        return curr;
    }
}
