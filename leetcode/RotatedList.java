public class RotatedList {
    public ListNode rotateRight(ListNode head, int n) {
        assert(n >= 0);
        if (head == null || n == 0) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        for (int i = 0; i < n; i++) {
            if (fast == null) fast = head;
            fast = fast.next;
            
        }
        
        if (fast == null) return head;
        
        while (fast.next != null) { 
            fast = fast.next;
            slow = slow.next;     
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
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
