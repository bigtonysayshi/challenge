package self;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree
 * along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 */
public class BinaryTreeLongestConsecutiveSequence {
    // Time: O(n) Space: O(n)
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode node, TreeNode parent, int len) {
        if (node == null) return len;
        len = (parent != null && node.val == parent.val + 1) ? len + 1 : 1;
        return Math.max(len, Math.max(dfs(node.left, node, len), dfs(node.right, node, len)));
    }
}
