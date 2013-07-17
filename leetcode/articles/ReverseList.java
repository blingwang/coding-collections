public class ReverseList {
    public ListNode ReverseListRec(ListNode head) {
        if (head == null) return null;
        ListNode rest = head.next;
        if (rest == null) return head;
        ListNode newHead = ReverseListRec(rest);
        rest.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode ReverseListIter(ListNode head) {
        //if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
