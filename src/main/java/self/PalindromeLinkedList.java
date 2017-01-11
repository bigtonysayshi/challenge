package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    // Time: O(n) Space: O(n)
    public boolean isPalindrome(ListNode head) {
        List<Integer> elements = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            elements.add(curr.val);
            curr = curr.next;
        }
        int start = 0, end = elements.size() - 1;
        while(start < end) {
            if (!elements.get(start).equals(elements.get(end))) return false;
            start++;
            end--;
        }
        return true;
    }
}
