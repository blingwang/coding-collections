public class MinTreeDepth {
    private int min;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        min = Integer.MAX_VALUE;
        dfs(root, 0);
        return min;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (depth + 1 < min) min = depth + 1;
            return;
        }
        
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
