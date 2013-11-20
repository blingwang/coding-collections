public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            
            current = current.next;
        }
        
        current.next = (l1 == null) ? l2 : l1;
        
        return dummyHead.next;
    }
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (true) {
            if (l1 == null) {
                pre.next = l2;
                break;
            }
            if (l2 == null) {
                pre.next = l1;
                break;
            }
            if (l2.val < l1.val) {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }
        }
        
        return dummyHead.next;
    }

    public ListNode mergeTwoListsRecur(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head = null;
        if (l2.val < l1.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        } 
        
        head.next = mergeTwoLists(l1, l2);
        
        return head;
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
