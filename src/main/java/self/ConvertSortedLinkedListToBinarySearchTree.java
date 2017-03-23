package self;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class ConvertSortedLinkedListToBinarySearchTree {
    // Time: O(n) Space: O(1)
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);
        return root;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        ConvertSortedLinkedListToBinarySearchTree instance = new ConvertSortedLinkedListToBinarySearchTree();
        System.out.println(instance.sortedListToBST(head));
    }
}
