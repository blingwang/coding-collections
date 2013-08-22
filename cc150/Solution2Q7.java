import java.util.*;

public class Solution {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        // push first half on to stack
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null) {//skip mid for list with odd # of nodes
            slow = slow.next;
        }
        
        // check second half against fisrt half
        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        
        return true;
    }
    
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        return isPalindromeRecurse(head, length(head)).isPalindrome;
    }
    
    private static Result isPalindromeRecurse(ListNode head, int length) {
        if (length == 1) {
            return new Result(head.next, true);
        }
        
        if (length == 2) {
            return new Result(head.next.next, head.val == head.next.val);
        }
        
        // recurse
        Result result = isPalindromeRecurse(head.next, length - 2);
        
        if (!result.isPalindrome) { // shortcut
            return result;
        }
        
        return new Result(result.next, head.val == result.next.val);
    }
    
    private static int length(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }
	
    public static void main(String[] args) {
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	
    	ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        
        System.out.println(isPalindrome2(head));
    }
    
    /**
     * Auxiliary class for isPalindromeRecurse 
     */
    private static class Result {
        boolean isPalindrome;
        ListNode next;
        Result(ListNode next, boolean isPalindrome) {
            this.isPalindrome = isPalindrome;
            this.next = next;
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
