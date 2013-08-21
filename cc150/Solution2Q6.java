public class Solution2Q6{
    public static ListNode FindLoopBeginning(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // let loop start be k steps from head
        // fast is k steps ahead of loop start when slow at loop start
        // i.e., fast is LOOP_SIZE - k steps from slow
        // slow and fast meet at LOOP_SIZE - k steps into the loop
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
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
