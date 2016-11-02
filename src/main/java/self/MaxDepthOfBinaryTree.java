package self;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaxDepthOfBinaryTree {
    // n = max depth. Time: O(2^n) Space: O(2^n)
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args){
        MaxDepthOfBinaryTree instance = new MaxDepthOfBinaryTree();
        System.out.println(instance.maxDepth(new TreeNode(0)));
    }
}
