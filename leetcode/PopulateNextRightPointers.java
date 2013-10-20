public class PopulateNextRightPointers {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        if (root.left != null) root.left.next = root.right;
        if (root.right != null && root.next != null) root.right.next = root.next.left;
        
        connect(root.left);
        connect(root.right);      
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
