package self;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null, current = root;
        while (current != null) {
            if (current.val == key) break;
            parent = current;
            current = current.val > key ? current.left : current.right;
        }
        if (current == null) return root;
        if (current.left != null && current.right != null) {
            findRightMostChild(current.left).right = current.right;
        }
        TreeNode next = null;
        if (current.left != null) {
            next = current.left;
        } else if (current.right != null) {
            next = current.right;
        }
        if (parent == null) return next;
        if (current.val < parent.val) {
            parent.left = next;
        } else {
            parent.right = next;
        }
        return root;
    }

    private TreeNode findRightMostChild(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
