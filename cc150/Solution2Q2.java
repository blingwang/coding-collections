import java.util.*;

public class Solution2Q2 {
    public static ListNode kthToLast(ListNode head, int k) {
        assert(k >= 1);
        ListNode slow = head;
        ListNode fast = head;

        // kth node jumps k steps to reach null
        for (int i = 0; i < k; i++) {
            if (fast == null) return null;// < k nodes
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    
    public static ListNode kthToLast2(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        
        // kth node jumps k-1 to reach end
        for (int i = 0; i < k -1; i++) {
            if (fast == null) return null;// < k-1 nodes
            fast = fast.next;
        }

        if (fast == null) return null; // = k-1 nodes

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    
    public static ListNode kthToLast3(ListNode head, int k) {
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
    	
    	System.out.println(kthToLast2(head, 3).val);
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
