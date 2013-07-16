public class Solution2Q2{
    class LinkedListNode{
        LinkedListNode next = null;
        int data;

        public LinkedListNode(int d){
            data = d;
        }
    }

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // move p2 forward k nodes into the list
        for(int i = 0; i < k -1; i++) {
            if (p2 == null) return null; // error check
            p2 = p2.next;
        }

        if(p2 == null) return null;

        // now move p1 and p2 at the same speed
        // when p2 hits the end, p1 will be at the right element
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
