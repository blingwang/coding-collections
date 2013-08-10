public class SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode first = head;
        ListNode newHead = head.next;
        while (first != null && first.next !=null) {
            ListNode second = first.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
            first = first.next;
        }
        
        return newHead;
    }
    
    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode second = head.next;
        head.next = second.next;
        second.next = head;
        head = second;
        head.next.next = swapPairs(head.next.next);
        
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
