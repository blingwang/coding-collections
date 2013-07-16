public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        int carrier = 0;
        int sum = 0;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum = l2.val + carrier;
                pre.next = new ListNode(sum % 10);
                carrier = sum / 10;
                pre = pre.next;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carrier;
                pre.next = new ListNode(sum % 10);
                carrier = sum / 10;
                pre = pre.next;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carrier;
                pre.next = new ListNode(sum % 10);
                carrier = sum / 10;
                pre = pre.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            
        }
        
        if (carrier != 0) pre.next = new ListNode(carrier);
        
        return dummyHead.next;
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
