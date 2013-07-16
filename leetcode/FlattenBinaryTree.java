public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        dfs(root);      
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        TreeNode leftEnd = dfs(root.left);
        TreeNode rightEnd = dfs(root.right);
        
        root.left = null;
        if (leftEnd != null) {
            root.right = left;
            leftEnd.right = right; 
        }
        
        if (rightEnd != null) {
            return rightEnd;
        } else if (leftEnd != null) {
            return leftEnd;
        }
        
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
