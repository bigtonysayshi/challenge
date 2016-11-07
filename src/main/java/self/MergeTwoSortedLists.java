package self;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node1 = l1, node2 = l2;
        ListNode resultHead;
        if (node1.val <= node2.val) {
            resultHead = node1;
            node1 = node1.next;
        } else {
            resultHead = node2;
            node2 = node2.next;
        }
        ListNode currentNode = resultHead;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                currentNode.next = node1;
                currentNode = node1;
                node1 = node1.next;
            } else {
                currentNode.next = node2;
                currentNode = node2;
                node2 = node2.next;
            }
        }
        currentNode.next = node1 != null ? node1 : node2;
        return resultHead;
    }


    // Clean recursive solution
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
