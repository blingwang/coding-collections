import java.util.*;

public class Solution2Q2 {
    public static ListNode kthToLast(ListNode head, int k) {
        ListNode n1 = head;
        ListNode n2 = head;

        // move n2 forward k nodes into the list
        for(int i = 0; i < k -1; i++) {
            if (n2 == null) return null; // error check
            n2 = n2.next;
        }

        if(n2 == null) return null;

        // now move n1 and n2 at the same speed
        // when n2 hits the end, n1 will be at the right element
        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }
    
    public static ListNode kthToLast2(ListNode head, int k) {
        if (k < 0) {
            return null;
        }
        
        return kthToLastRecur(head, k).node;
    }
    
    public static NthNode kthToLastRecur(ListNode head, int k) {
        if (head == null) {
            return new NthNode(null, -1);
        }
        
        NthNode nth = kthToLastRecur(head.next, k);
        if (nth.n == k) {
            return nth;
        } else {
            return new NthNode(head, nth.n + 1);
        }
        
    }
	
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(2);
    	
    	ListNode cur = head;
    	while (cur != null) {
    	    System.out.println(cur.val);
    	    cur = cur.next;
    	}
    	
    	System.out.println(kthToLast2(head, -3).val);
    }
    
    /**
     * Auxiliary class for use in kthToLastRecur()
     */
    private static class NthNode {
        ListNode node;
        int n;
        NthNode(ListNode node, int n) {
            this.node = node;
            this.n = n;
        }
    }
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
