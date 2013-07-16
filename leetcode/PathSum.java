public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null && root.val == sum) return true;
        
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
