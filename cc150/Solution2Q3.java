public class Solution2Q3 {
    public static boolean deleteNode(ListNode n) {
        if (n == null || n.next == null) {
            return false;//failure: unable to delete last
        }

        ListNode next = n.next;
        n.val = next.val;
        n.next = next.next;
        return true;
    }
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
