public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode middle = getMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null;
        
        return merge(sortList(head), sortList(secondHalf));
    }
    
    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        
        current.next = (l1 == null) ? l2 : l1;
        return dummyHead.next;
    }
}
