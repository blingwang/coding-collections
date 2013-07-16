public class Solution4Q5 {
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static int last_printed = Integer.MIN_VALUE;
    public static boolean inOrderCheckBST(TreeNode n) {
        if(n == null) return true;

        // check left
        if (!inOrderCheckBST(n.left)) return false;

        // check current
        if (n.data < last_printed) return false;
        last_printed = n.data;

        // check right
        if (!inOrderCheckBST(n.right)) return false;

        return true; // all good
    }

    public boolean checkBST(TreeNode n) {
        return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode n, int min, int max) {
        if (n == null) {
            return true;
        }

        if(n.data <= min || n.data > max) {
            return false;
        }

        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }

        return true;
    }
}
