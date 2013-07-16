public class DedupSortedList1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode pre = head;
        ListNode current = head.next;
        while(current != null) {
            if (current.val == pre.val) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            
            current = current.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
