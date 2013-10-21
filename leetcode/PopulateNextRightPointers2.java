public class PopulateNextRightPointers2 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode nextRoot = null;
        TreeLinkNode preNode = null;
        
        for (TreeLinkNode current = root; current != null; current = current.next) {
            if (current.left != null) {
                if (nextRoot == null) nextRoot = current.left;
                if (preNode != null) preNode.next = current.left;
                preNode = current.left;
            }
            
            if (current.right != null) {
                if (nextRoot == null) nextRoot = current.right;
                if (preNode != null) preNode.next = current.right;
                preNode = current.right;
            }
        }
        
        connect(nextRoot);
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
