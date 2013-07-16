public class Solution4Q8 {
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return subTree(t1,t2);
    }

    private boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        }

        if (r1.data == r2.data && matchTree(r1, r2)) {
            return true;
        }

        return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    private boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            //if both are empty, nothing left in the subtree
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.data != r2.data) {
            return false; // data doesn't match
        }

        return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
    }
}
