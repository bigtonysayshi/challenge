package self;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note: You may only use constant extra space.
 */
public class PopulatingNextRightPointersInEachNode2 {
    // Time: O(n) Space: O(1)
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode current = levelStart;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = findNext(current, true);
                }
                if (current.right != null) {
                    current.right.next = findNext(current, false);
                }
                current = current.next;
            }
            levelStart = levelStart.left != null ? levelStart.left : findNext(levelStart, true);
        }
    }

    private TreeLinkNode findNext(TreeLinkNode current, boolean left) {
        if (current == null) return null;
        if (current.right != null && left) return current.right;
        current = current.next;
        while (current != null) {
            if (current.left != null) return current.left;
            if (current.right != null) return current.right;
            current = current.next;
        }
        return null;
    }
}
