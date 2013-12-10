public class Solution4Q7 { 
    // if has parent pointer, store one path in hashmap, check the other path
    /* solution 1 */
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (inTree(root.left, p) && inTree(root.left, q)) {
            return lca(root.left, p, q);
        }

        if (inTree(root.right, p) && inTree(root.right, q)) {
            return lca(root.right, p, q);
        }

        return root;
    }

    private static boolean inTree(TreeNode root, TreeNode n) {
        if (root == null) return false;
        if (n.val == root.val) return true;
        return inTree(root.left, n) || inTree(root.right, n);
    }

    /* solution 2: assume p and q are in tree */
    public static TreeNode lcaBU(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lcaBU(root.left, p, q);
        TreeNode right = lcaBU(root.right, p, q);

        if (left != null && right != null) return root;

        return left == null ? right : left;
    }

    /* solution 3: p, q may not be in tree */
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    private static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return new Result(null, false);
        }

        if (root == p && root == q) {
            return new Result(root, true);
        }

        Result left = commonAncestorHelper(root.left, p, q);
        if(left.isAncestor) {
            return left;// found common ancestor
        }

        Result right = commonAncestorHelper(root.right, p, q);
        if (right.isAncestor) {
            return right;//found common ancestor
        }

        if (left.node != null && right.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
            // If we're currently at p or q, and we also found one of
            // those nodes in a subtree, then this is truly an ancestor
            // and the flag should be true
            boolean isAncestor = left.node != null || right.node != null ? true : false;
            return new Result(root, isAncestor);
        } else {
            return new Result(left.node != null ? left.node : right.node, false);
        }
    }

    public static TreeNode sortedArrayToBST(int[] a) {
        return sortedArrayToBST(a, 0, a.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] a, int lo, int hi) {
        if (lo > hi) return null;

        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(a[mid]);

        root.left = sortedArrayToBST(a, lo, mid - 1);
        root.right = sortedArrayToBST(a, mid + 1, hi);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int[] a = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bst = sortedArrayToBST(a);
        bst.print();
        System.out.println();
        System.out.println(lcaBU(root, root.left, root.right).val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

        public void print() {
            System.out.print(val);
            if (left != null) left.print();
            if (right != null) right.print();
        }
    }

    private static class Result {
        TreeNode node;
        boolean isAncestor;
        Result(TreeNode node, boolean isAncester) {
            this.node = node;
            this.isAncestor = isAncester;
        }
    }
}
