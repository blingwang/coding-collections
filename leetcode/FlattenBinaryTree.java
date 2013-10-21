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
    
    public void flatten2(TreeNode root) { // iterative solution
        TreeNode current = root;
        
        while (current != null) {
            if (current.left != null) {
                if (current.right != null) {// if we need to prune a right subtree
                    TreeNode next = current.left;
                    while (next.right != null) next = next.right;
                    next.right = current.right;
                }
                
                current.right = current.left;
                current.left = null;
            }
            
            current = current.right;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
