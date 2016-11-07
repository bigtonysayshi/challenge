package self;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n1 = head;
        ListNode n2 = n1.next;
        head = n2;

        while (n2.next != null) {
            ListNode n3 = n2.next;
            ListNode n4 = n3.next;
            if (n4 == null) {
                n1.next = n3;
                n2.next = n1;
                break;
            } else {
                n1.next = n4;
                n2.next = n1;
                n1 = n3;
                n2 = n4;
            }
        }
        if (n2.next == null) {
            n1.next = null;
            n2.next = n1;
        }
        return head;
    }

    // Clean recursive solution
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;

        second.next = head;
        head.next = swapPairs(third);

        return second;
    }

    // Good iterative solution using dummy node
    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}
