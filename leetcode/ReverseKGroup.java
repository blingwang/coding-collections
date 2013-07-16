public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode preGroup = dummyHead;
        ListNode slow = head; // window: [slow, fast]
        ListNode fast = head;
        
        for (int i = 1; i < k; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }
        
        while (fast != null) { // for group: [slow, fast]
            preGroup.next = fast;
            preGroup = slow;
            ListNode pre = fast.next;
            for (int i = 0; i < k; i++) { // sliding window
                ListNode next = slow.next;
                slow.next = pre;
                pre = slow;
                slow = next;
                if (fast != null) fast = fast.next;
            }
        }
        
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
