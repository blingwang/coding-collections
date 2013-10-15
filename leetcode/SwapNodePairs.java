public class SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode first = head;
        
        while (first!= null && first.next != null) {
            ListNode second = first.next;
            ListNode next = second.next;
            
            pre.next = second;
            second.next = first;
            first.next = next;
            
            pre = first;
            first = next;
        }
        
        return dummy.next;
    }
    
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            
            cur.next = second;
            first.next = second.next;
            second.next = first;
            
            cur = first; 
        }
        
        return dummy.next;
    }
    
    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode second = head.next;
        head.next = swapPairs(second.next);;
        second.next = head;
        
        return second;
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
