public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            insertSortedList(current, dummy);
            current = next;
        }
        
        return dummy.next;
    }
    
    private void insertSortedList(ListNode node, ListNode head) {
        ListNode current = head;
        
        while (current.next != null) {
            if (current.next.val >= node.val) {
                node.next = current.next;
                current.next = node;
                return;
            }
            
            current = current.next;
        }
        
        current.next = node;
        node.next = null;
    }
}
