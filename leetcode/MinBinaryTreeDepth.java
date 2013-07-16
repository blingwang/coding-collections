import java.util.*;
public class MinBinaryTreeDepth {
    int min;

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
        min = Integer.MAX_VALUE;
        inorderTraversal(0, root);
        return min;
    }

    private void inorderTraversal(int depth, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            min = Math.min(min, depth + 1);
        }
        inorderTraversal(depth + 1, root.left);
        inorderTraversal(depth + 1, root.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; };
    }
}
