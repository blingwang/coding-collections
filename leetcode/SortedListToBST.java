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
