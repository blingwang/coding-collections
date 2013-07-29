public class MaxTreeDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    int maxDepth;
    public int maxDepth2(TreeNode root) {
        maxDepth = 0;
        dfs(root, 0);
        return maxDepth;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        
        if (depth + 1 > maxDepth) maxDepth = depth + 1;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
