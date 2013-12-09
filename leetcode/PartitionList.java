public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHeader = new ListNode(0);
        ListNode greaterHeader = new ListNode(0);
        ListNode less = lessHeader;
        ListNode greater = greaterHeader;
        
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                greater.next = cur;
                greater = greater.next;
            }
        }
        
        less.next = greaterHeader.next;
        greater.next = null;
        
        return lessHeader.next;
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
