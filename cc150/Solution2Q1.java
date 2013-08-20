import java.util.*;

public class Solution2Q1 {
    public static void dedupList(ListNode head) {
        Set<Integer> found = new HashSet<Integer>();
        ListNode cur = head;
        ListNode pre = null;
        
        while (cur != null) {
            if (found.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                found.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }
    
    public static void deleteDupsNoBuffer(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current;

            // remove all future nodes that have the same value
            while (runner.next != null ) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
	
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(2);
    	deleteDupsNoBuffer(head);
    	
    	ListNode cur = head;
    	while (cur != null) {
    	    System.out.println(cur.val);
    	    cur = cur.next;
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
