import java.util.*;

public class Solution2Q7{
    class LinkedListNode{
        LinkedListNode next = null;
        int data;

        public LinkedListNode(int d){
            data = d;
        }
    }
    
    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        // push elements from first half of linked list onto stack.
        // when fast runner reaches the end of the linked list, 
        // then we know slow is at the middle
        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // has odd number of elements, so skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null){
            int top = stack.pop();

            // if values are different, then it's not a palindrome
            if (top != slow.data) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }

    // recursive approach
    class Result{
        public LinkedListNode node;
        public boolean result;

        Result(LinkedListNode n, boolean r) {
            node = n;
            result = r;
        }
    }

    Result isPalindromeRecurse(LinkedListNode head, int length) {
        if(head == null || length == 0){
            return new Result(null, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        } else if (length == 2) {
            return new Result(head.next.next, head.data == head.next.data);
        }

        Result res = isPalindromeRecurse(head.next, length -2);
        if(!res.result || res.node == null) {
            return res;
        } else {
            res.result = head.data == res.node.data;
            res.node = res.node.next;
            return res;
        }
    }

    boolean isPalindromeRecurse(LinkedListNode head) {
        Result p = isPalindromeRecurse(head, listSize(head));
        return p.result;
    }

    private int listSize(LinkedListNode head) {
        int size = 0;

        while(head != null){
            size++;
            head = head.next;
        }

        return size;
    }
}
