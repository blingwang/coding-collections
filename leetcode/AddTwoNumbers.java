public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        int carrier = 0;
        
        while (l1 != null || l2 != null) {
            int val1 = 0, val2 = 0;
            
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                val2 = l2.val;
                l2= l2.next;
            }
            
            int sum = val1 + val2 + carrier;
            carrier = sum / 10;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
        }
        
        if (carrier != 0) pre.next = new ListNode(carrier);
        
        return dummyHead.next;
    }
    
    int carrier;
    public ListNode addTwoNumbersNonreverse(ListNode l1, ListNode l2) {
        carrier = 0;
        ListNode result = addTwoNumbersNonreverseRecur(l1, l2);
        ListNode head = result;
        if (carrier != 0) {
            head = new ListNode(carrier);
            head.next = result;
        }
        return head;
    }

    public ListNode addTwoNumbersNonreverseRecur(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode next = addTwoNumbersNonreverseRecur(l1.next, l2.next);
        int sum = l1.val + l2.val + carrier;
        int curDigit = sum % 10;
        carrier = sum / 10;
        ListNode cur = new ListNode(curDigit);
        cur.next = next;
        return cur;  
    }

    public ListNode addTwoNumbersNonreverseIter(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode lastNonNine = dummy;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            int curDigit = sum % 10;
            int carrier = sum / 10;
            
            ListNode cur = new ListNode(curDigit);
            
            if (carrier != 0) { // add carrier to previous nodes
                lastNonNine.val++;
                ListNode nineNode = lastNonNine.next;
                while (nineNode != null) {
                    nineNode.val = 0;
                    nineNode = nineNode.next;
                }
            }
            
            if (curDigit != 9) lastNonNine = cur;
            
            pre.next = cur;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return dummy.val == 0 ? dummy.next : dummy;
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
