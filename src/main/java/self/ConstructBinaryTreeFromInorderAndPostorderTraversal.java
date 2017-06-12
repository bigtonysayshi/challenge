package self;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) {
            return null;
        }
        int n = inorder.length;
        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inOrderRootIdx = inStart;
        while (inOrderRootIdx <= inEnd && inorder[inOrderRootIdx] != rootVal) {
            inOrderRootIdx++;
        }
        int leftSize = inOrderRootIdx - inStart;
        TreeNode left = leftSize > 0 ? build(inorder, postorder, inStart, inOrderRootIdx - 1, postStart, postStart + leftSize - 1) : null;
        int rightSize = inEnd - inOrderRootIdx;
        TreeNode right = rightSize > 0 ? build(inorder, postorder, inOrderRootIdx + 1, inEnd, postStart + leftSize, postEnd - 1) : null;
        root.left = left;
        root.right = right;
        return root;
    }
}
