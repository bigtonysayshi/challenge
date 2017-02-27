package self;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val == root.val) {
            TreeNode next= root.right;
            while (next != null && next.left != null) {
                next = next.left;
            }
            return next;
        }
        if (p.val < root.val) {
            TreeNode next = inorderSuccessor(root.left, p);
            return next == null ? root : next;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
}
