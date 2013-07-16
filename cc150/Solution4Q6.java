public class Solution4Q6 {
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }

        while (n.left != null) {
            n = n.left;
        } 

        return n;
    }

    public TreeNode inOrderSucc(TreeNode n) {
        if (n == null) {
            return null;
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;
            // Go up until we are on left instead of right.
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }
}
