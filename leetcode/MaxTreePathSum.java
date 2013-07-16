public class MaxTreePathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxRootPathSum(root);
        return maxSum;
    }

    private int maxRootPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int rootPathLeftSum = root.val;
        int rootPathRightSum = root.val;
        
        int leftMax = maxRootPathSum(root.left);
        int rightMax = maxRootPathSum(root.right);
        if (leftMax > 0) rootPathLeftSum += leftMax;
        if (rightMax > 0) rootPathRightSum += rightMax;
        int rootPathSum = rootPathLeftSum + rootPathRightSum - root.val;
        if (rootPathSum > maxSum) maxSum = rootPathSum;
        
        return Math.max(rootPathLeftSum, rootPathRightSum);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
