package self;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pPath = new LinkedList<>(), qPath = new LinkedList<>();
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        TreeNode result = null;
        while (!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode pNode = pPath.pop();
            TreeNode qNode = qPath.pop();
            if (pNode == qNode) {
                result = pNode;
            } else {
                break;
            }
        }
        return result;
    }

    private boolean findPath(TreeNode root, TreeNode target, Deque<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            path.push(root);
            return true;
        }
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            path.push(root);
            return true;
        }
        return false;
    }
}
