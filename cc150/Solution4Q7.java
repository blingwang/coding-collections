public class Solution4Q7 {
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    //return ture if p is a descendent of root
    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;

        return covers(root.left, p) || covers(root.right, p);
    }

    private TreeNode commonAncesterHelper(TreeNode root, TreeNode p, TreeNode q) {
        boolean is_p_on_left = covers(root.left, p);
        boolean is_q_on_left = covers(root.right, q);

        // if p and q are on different sides, return root;
        if (is_p_on_left != is_q_on_left) return root;

        // else they are on the same side, traverse this side
        TreeNode childNode = is_p_on_left ? root.left : root.right;
        return commonAncesterHelper(childNode, p, q);
    }

    private class Result {
        public TreeNode node;
        public boolean isAncestor;

        public Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }

    Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return new Result(null, false);
        }

        if (root == p && root == q) {
            return new Result(root, true);
        }

        Result rx = commonAncestorHelper(root.left, p, q);
        if(rx.isAncestor) {
            return rx;// found common ancestor
        }

        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) {
            return ry;//found common ancestor
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
            // If we're currently at p or q, and we also found one of 
            // those nodes ina subtree, then this is truly an ancestor 
            // and the flag should be true
            boolean isAncestor = rx.node != null || ry.node != null ? true : false;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }
}
