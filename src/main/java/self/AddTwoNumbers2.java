package self;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class AddTwoNumbers2 {
    // Time: O(n1+n2) Space: O(n1+n2)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        int len1 = list1.size(), len2 = list2.size(), len = Math.max(len1, len2);
        boolean carry = false;
        ListNode curr = null, prev = null;
        for (int i = 1; i <= len; i++) {
            int n1 = i <= len1 ? list1.get(len1 - i) : 0;
            int n2 = i <= len2 ? list2.get(len2 - i) : 0;
            int sum = n1 + n2 + (carry ? 1 : 0);
            carry = sum >= 10;
            curr = new ListNode(sum % 10);
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
