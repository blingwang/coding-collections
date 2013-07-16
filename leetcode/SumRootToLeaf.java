public class SumRootToLeaf {
    int sum;

    public int sumNumbers(TreeNode root) {
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
