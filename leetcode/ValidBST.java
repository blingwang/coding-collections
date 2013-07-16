public class ValidBST {
    int pre;

    public boolean isValidBST(TreeNode root) {
        //pre = Integer.MIN_VALUE;
        //return inOrder(root); 
        return inRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean inRange(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return inRange(root.left, min, root.val) && inRange(root.right, root.val, max);
    }

    private boolean inOrder(TreeNode root) {
        if (root == null) return true;
        
        if (!inOrder(root.left)) return false;   
        if (root.val <= pre) return false;
        pre = root.val;       
        if (!inOrder(root.right)) return false;
        
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
