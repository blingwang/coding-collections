public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pivot = new ListNode(-1);
        ListNode lt = dummyHead;
        ListNode ge = pivot;
        ListNode current = head;
        
        while (current != null) {
            if (current.val < x) {
                lt.next = current;
                lt = lt.next;
            } else {
                ge.next = current;
                ge = ge.next;
            }
            current = current.next;
        }
        
        lt.next = pivot.next;
        ge.next = null;
        
        return dummyHead.next;
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
