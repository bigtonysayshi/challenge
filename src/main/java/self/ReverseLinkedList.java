package self;

/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    // Time: O(n) Space: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode current = head;
        current.next = null;

        while (next.next != null) {
            ListNode tmp = next.next;
            next.next = current;
            current = next;
            next = tmp;
        }
        next.next = current;
        return next;
    }
}
