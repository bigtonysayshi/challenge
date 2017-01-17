package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer represented as non-empty a singly linked list of digits,
 * plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOneLinkedList {
    // Time: O(n) Space: O(n)
    public ListNode plusOne(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            vals.add(node.val);
            node = node.next;
        }
        boolean carry = true;
        ListNode curr = null, prev = null;
        for (int i = vals.size() - 1; i >= 0; i--) {
            int val = vals.get(i);
            if (carry) {
                if (val == 9) {
                    val = 0;
                    carry = true;
                } else {
                    val++;
                    carry = false;
                }
            }
            curr = new ListNode(val);
            curr.next = prev;
            prev = curr;
        }
        if (carry) {
            curr = new ListNode(1);
            curr.next = prev;
        }
        return curr;
    }
}
