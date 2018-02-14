public class ValidBST {
    // what if left-most leaf = Integer.MIN_VALUE?
    public boolean isValidBST(TreeNode root) {
        //return inOrder(root); 
        //return inRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        return inorder2(root, pre);
    }

    private boolean inRange(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return inRange(root.left, min, root.val) && inRange(root.right, root.val, max);
    }
    
    private boolean inorder (TreeNode root, TreeNode pre) {
        if (root == null) return true;
        
        if (!inorder(root.left, pre))  return false;
        if (root.val <= pre.val)       return false;
        pre.val = root.val;
        if (!inorder(root.right, pre)) return false;
        
        return true;
    }
    
    private TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (!isValidBST(root.left)) {
            return false;
        }
        
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        
        pre = root;
        
        return isValidBST(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
