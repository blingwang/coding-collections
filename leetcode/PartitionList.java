public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                greater.next = cur;
                greater = greater.next;
            }
        }
        
        less.next = greaterHead.next;
        greater.next = null;
        
        return lessHead.next;
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
