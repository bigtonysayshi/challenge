package self;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedList {
    // Each pointer goes up to two iterations.
    // First iteration, if reaching the end without overlapping, start from the other list.
    // Second iteration, guaranteed to overlap at the first diverging point.
    // Time: O(n) Space:O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
