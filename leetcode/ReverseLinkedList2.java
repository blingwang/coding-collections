public class ReverseLinkedList2 {
    public ListNode reverseBetweenShorter(ListNode head, int m, int n) {
        if (m >= n || head == null) return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode preM = dummyHead;
        
        for (int i = 1; i <= n; i++) {
            if (i == m) preM = pre;
            
            if (i > m && i <= n) {
                pre.next = head.next;
                head.next = preM.next;
                preM.next = head;
                head = pre; // head has been moved, so pre becomes current
            }
            pre = head;
            head = head.next;   
        }
        
        return dummyHead.next;
    }   

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode current = head;
        int count = 0;
        
        while (current != null) {
            count++;
            if (count == m) break;
            pre = current;
            current = current.next;     
        }
        
        ListNode beforeM = pre;
        ListNode nodeM = current;
        pre = null;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            
            if (count == n) {
                beforeM.next.next = next;
                beforeM.next = current; 
                break;
            }
            
            pre = current;
            current = next;           
            count++;
        }
        
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
