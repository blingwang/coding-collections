import java.util.*;
public class MinBinaryTreeDepth {
    public int minDepth(TreeNode root) {
        return minDepthBFS(root);
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        int curCount = 0;
        int nextCount = 0;

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        nextCount++;
        
        while (!queue.isEmpty()) {
            if (curCount == 0) {
                curCount = nextCount;
                nextCount = 0;
                depth++;
            }
            
            TreeNode node = queue.poll();
            curCount--;
            
            if (node.left == null && node.right == null) break;
            if (node.left != null) {
                queue.offer(node.left);
                nextCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextCount++;
            } 
        }
        
        return depth;
    }
    
    public int minDepthDFS(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;   
    }

    int min;
    public int minDepthDFS2(TreeNode root) {
        if (root == null) return 0;
        min = Integer.MAX_VALUE;
        dfs(0, root);
        return min;
    }

    private void dfs(int depth, TreeNode root) { // top down
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            min = Math.min(min, depth + 1);
        }
        
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; };
    }
}
