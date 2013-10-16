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
    
    private TreeNode sortedListToBST2(ListNode head, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(head, start, mid - 1);
        TreeNode parent = new TreeNode(head.val);
        
        // Java pass in Object by reference, so we can't change head but we can change its content :)
        if (head.next != null) { // "move to next"
            head.val = head.next.val;
            head.next = head.next.next;
        }
        
        TreeNode right = sortedListToBST(head, mid + 1, end);
        parent.left = left;
        parent.right = right;
        
        return parent;
    }

    private int computeListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        
        return length;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
