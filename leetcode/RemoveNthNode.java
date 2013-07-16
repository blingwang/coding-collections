public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
