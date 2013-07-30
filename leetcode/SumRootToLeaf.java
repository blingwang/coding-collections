public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int curSum) {
        if (root == null) return 0; // don't return curSum
        
        curSum = curSum * 10 + root.val;
        
        // only return result if leaf node
        if (root.left == null && root.right == null) return curSum;
        
        return sumNumbers(root.left, curSum) + sumNumbers(root.right, curSum); 
    }

    private int sum;
    public int sumNumbers2(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int curSum) {
        if (root == null) return;
        
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) sum += curSum;
        dfs(root.left, curSum);
        dfs(root.right, curSum);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
