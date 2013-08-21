public class Solution2Q5{
    public static ListNode addLists(ListNode l1, ListNode l2) {
        return addLists(l1, l2, 0);
    }

    private static ListNode addLists(ListNode l1, ListNode l2, int carry) {
        // we are done if both lists are null and the carry value is 0
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        // add carry, and values from l1 and l2
        int sum = carry;
        if(l1 != null) {
            sum += l1.val;
        }
        if(l2 != null) {
            sum += l2.val;
        }

        carry = sum / 10;
        int value = sum % 10;
        ListNode result = new ListNode(value);

        // recurse
        ListNode next1 = (l1 == null) ? null : l1.next;
        ListNode next2 = (l2 == null) ? null : l2.next;
        result.next = addLists(next1, next2, carry);

        return result;
    }

    public static ListNode addReverseLists(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        // pad the shorter lists with leading zeros
        if(len1 < len2){
            l1 = padList(l1, len2-len1);
        } else {
            l2 = padList(l2, len1-len2);
        }

        PartialSum sum = addListsHelper(l1, l2);

        if(sum.carry == 0) {
            return sum.node;
        } else {
            ListNode result = insertBefore(sum.node, sum.carry);
            return result;
        }
    }

    private static PartialSum addListsHelper(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return new PartialSum(null, 0);
        }
        
        PartialSum nextSum = addListsHelper(l1.next, l2.next);
        
        int sum = nextSum.carry + l1.val + l2.val;
        ListNode curNode = insertBefore(nextSum.node, sum % 10);
        PartialSum curSum = new PartialSum(curNode, sum / 10);
        
        return curSum;
    }

    // pad the list with zeros
    private static ListNode padList(ListNode l, int padding) {
        ListNode head = l;

        for (int i = 0; i < padding; i++) {
            head  = insertBefore(head, 0);
        }
        
        return head;
    }

    // helper function to insert node in the front of a linked list
    private static ListNode insertBefore(ListNode list, int val){
        ListNode node = new ListNode(val);
        node.next = list;
        return node;
    }
    
    private static  int length(ListNode list) {
        int length = 0;
        ListNode cur = list;
        
        while(cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }
	
    public static void main(String[] args) {
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(1);
    	
    	for (ListNode cur = head; cur != null; cur = cur.next) {
    		System.out.println(cur.val);
    	}
    	
    	ListNode head2 = new ListNode(8);
        head2.next = new ListNode(7); 
    	
    	ListNode cur = addReverseLists(head, head2);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    
    // for lists with reverse order
    private static class PartialSum {
        ListNode node;
        int carry;
        PartialSum(ListNode node, int carry) {
            this.node = node;
            this.carry = carry;
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
