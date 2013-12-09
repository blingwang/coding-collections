public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode middle = getMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null;
        
        secondHalf = reverse(secondHalf);
        mergeTwoHalves(head, secondHalf);
    }
    
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        
        return pre;
    }
    
    private void mergeTwoHalves(ListNode first, ListNode second) {
        // insert each node in second half into first alternately
        while (second != null) {
            ListNode nextInSecond = second.next;
            second.next = first.next;
            first.next = second;
            first = first.next.next;
            second = nextInSecond;
        }
    }
}
