public class SortedListToBST {
    ListNode curHead;

    public TreeNode sortedListToBST(ListNode head) {
        curHead = head;
        int length = computeListLength(head);
        return sortedListToBST(length);
    }

    private TreeNode sortedListToBST(int length) {
        if (curHead == null || length <= 0) return null;

        TreeNode left = sortedListToBST(length/2);
        TreeNode root = new TreeNode(curHead.val);
        curHead = curHead.next;
        TreeNode right = sortedListToBST((length-1)/2);
        root.left = left;
        root.right = right;

        return root;
    }
    
    public TreeNode sortedListToBST2(ListNode head) {
        int n = computeListLength(head);
        if (head == null) return null;
        ListNode curNode = new ListNode(head.val);
        curNode.next = head.next;
        return sortedListToBST(curNode, 0 , n - 1);
    }
    
    private TreeNode sortedListToBST(ListNode curNode, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(curNode, start, mid - 1);
        TreeNode parent = new TreeNode(curNode.val);
        
        // Java pass in Object by reference, so we can't change head but we can change its content :)
        if (curNode.next != null) { // "move to next"
            curNode.val = curNode.next.val;
            curNode.next = curNode.next.next;
        }
        
        TreeNode right = sortedListToBST(curNode, mid + 1, end);
        parent.left = left;
        parent.right = right;
        
        return parent;
    }
    
    private int computeListLength(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
