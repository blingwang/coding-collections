public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        assert(n >= 1);
        ListNode slow = head;
        ListNode fast = head;
        
        for (int i = 0; i < n; i++) {
            if (fast == null) return head; // < n nodes
            fast = fast.next;
        }
        
        if (fast == null) return head.next; // = n nodes
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        assert(n > 0);
        if (head == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        
        if (fast == null) return head.next;
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
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
