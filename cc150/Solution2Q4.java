public class Solution2Q4{
    public static ListNode partition(ListNode node, int x) {
        ListNode dummyBefore = new ListNode(0);
        ListNode dummyAfter = new ListNode(0);
        ListNode before = dummyBefore;
        ListNode after = dummyAfter;
        ListNode cur = node;
        
        // partition list
        while (cur != null) {
            if (cur.val < x) {
                before.next = cur;
                before = before.next;
            } else {
                after.next = cur;
                after = after.next;
            }
            
            cur = cur.next;
        }
        
        // merge two lists and set end
        before.next = dummyAfter.next;
        after.next = null;
        
        return dummyBefore.next;
    }
    
    public static ListNode partition2(ListNode node, int x) {
        ListNode before = null;
        ListNode after = null;

        // partition list
        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                //insert node before start of before list
                node.next = before;
                before = node;
            } else {
                // insert node before start of after list
                node.next = after;
                after = node;
            }

            node = next;
        }

        if (before == null) {
            return after;
        }

        // find end of before list and merge the lists
        ListNode head = before;
        while (before.next != null) {
            before = before.next;
        }
        before.next = after;

        return head;
    }
	
    public static void main(String[] args) {
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(1);
    	
    	head = partition(head, 2);
    	
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

