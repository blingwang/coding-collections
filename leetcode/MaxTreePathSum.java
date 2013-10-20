public class MaxTreePathSum {
    public int maxPathSum(TreeNode root) {
        Data data = dfs(root);
        return data.maxSum;
    }
    
    private Data dfs(TreeNode root) {// post order
        Data data = new Data();
        if (root == null) return data;
        
        Data left = dfs(root.left);
        Data right = dfs(root.right);
        
        // partial path can be empty
        data.partialPath = Math.max(0, Math.max(left.partialPath, right.partialPath) + root.val);
        data.maxSum = max(left.maxSum, right.maxSum, left.partialPath + root.val + right.partialPath);
        
        return data;
    }
    
    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    
    private class Data {
        int partialPath = 0; // partialPath >= 0
        int maxSum = Integer.MIN_VALUE;
    }
}
