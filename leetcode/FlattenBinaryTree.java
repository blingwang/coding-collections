public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    
    private TreeNode flattenTree(TreeNode root) {// return last visited node
        if (root == null) return null;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode end = root; // end of flattened tree so far
        
        if (left != null) { // insert left
            root.left = null;
            root.right = left;
            end = flattenTree(left);
            end.right = right;
        }
    
        if (right != null) {
            end = flattenTree(right);
        }
        
        return end;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
