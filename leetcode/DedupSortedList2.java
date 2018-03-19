/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur = skipDuplicates(cur);
            } else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        
        pre.next = null;
        return dummyHead.next;
    }
    
    private ListNode skipDuplicates(ListNode head) {
        int dupVal = head.val;
        while (head != null && head.val == dupVal) {
            head = head.next;
        }    
        return head;
    }
}
