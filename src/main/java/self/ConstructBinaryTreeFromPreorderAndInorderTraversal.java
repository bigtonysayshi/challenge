package self;

import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        HashMap<Integer, Integer> inIdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inIdxMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1, inIdxMap);
    }

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart,
                           int preEnd, HashMap<Integer, Integer> inIdxMap) {
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inOrderRootIdx = inIdxMap.get(rootVal);
        int leftSize = inOrderRootIdx - inStart;
        TreeNode left = leftSize > 0 ? build(preorder, inorder, inStart, inOrderRootIdx - 1, preStart + 1, preStart + leftSize, inIdxMap) : null;
        int rightSize = inEnd - inOrderRootIdx;
        TreeNode right = rightSize > 0 ? build(preorder, inorder, inOrderRootIdx + 1, inEnd, preStart + leftSize + 1, preEnd, inIdxMap) : null;
        root.left = left;
        root.right = right;
        return root;
    }
}
