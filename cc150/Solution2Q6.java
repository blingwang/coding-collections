public class Solution2Q6{
    class LinkedListNode{
        LinkedListNode next = null;
        int data;

        public LinkedListNode(int d){
            data = d;
        }
    }

    LinkedListNode FindLoopBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // find meeting point
        // this will be LOOP_SIZE - k steps into the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// collision
                break;
            }
        }

        // error check - no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        // move slow to head. keep fast at meeting point
        // each are k steps from the loop start
        // if they move at the same pace, they must meet at loop start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // both now point to the start of the loop
        return fast;
    }
}
