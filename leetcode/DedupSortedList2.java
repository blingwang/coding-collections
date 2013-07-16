public class DedupSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        ListNode current = head;
        
        while (current != null) {
            if (current.next == null || current.val != current.next.val) {
                pre.next = current;
                pre = current;
                current = current.next;
            } else {
                int dupValue = current.val;
                while (current != null && current.val == dupValue) {
                    current = current.next;
                }
            }
        }
        
        pre.next = null;
        
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
