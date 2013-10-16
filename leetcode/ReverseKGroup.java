public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode preGroup = dummy;
        ListNode cur = head;
        
       while (cur != null) {
            count++;
            ListNode next = cur.next;
            
            if (count % k == 0) {
                ListNode start = preGroup.next;
                preGroup.next = reverseKNodes(start, next, k);
                preGroup = start;
            }
            
            cur = next;
        }
        
        return dummy.next;
    }
    
    private ListNode reverseKNodes(ListNode start, ListNode pre, int k) {
        ListNode cur = start;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    public ListNode reverseKGroupTwoPointers(ListNode head, int k) {
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
