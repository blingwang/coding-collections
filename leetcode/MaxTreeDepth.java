public class MaxTreeDepth {
    int maxDepth;

    public int maxDepth(TreeNode root) {
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
