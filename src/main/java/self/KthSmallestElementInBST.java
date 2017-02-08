package self;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInBST {
    // DFS Binary Search
    public int kthSmallest(TreeNode root, int k) {
        int leftNodes = countNodes(root.left);
        if (k <= leftNodes) {
            return kthSmallest(root.left, k);
        } else if (k > leftNodes + 1) {
            return kthSmallest(root.right, k - leftNodes - 1);
        }
        return root.val;
    }

    private int countNodes(TreeNode node) {
        return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
    }

    // In order traversal
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curr = root;
        int rank = 0;
        while (!nodeStack.empty() || curr != null) {
            if (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            } else {
                curr = nodeStack.pop();
                if (++rank == k) return curr.val;
                curr = curr.right;
            }
        }
        return -1;
    }


}
