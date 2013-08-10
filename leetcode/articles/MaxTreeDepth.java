import java.util.*;
public class MaxTreeDepth {
    public static int maxDepthPostorderIterative(TreeNode root) { 
        if (root == null) return 0;
        int maxDepth = 0;
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();// store dfs path
        stack.push(root);
        TreeNode previous = null;

        while(!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) stack.push(current.left);
                else if (current.right != null) stack.push(current.right);
            } else if (previous == current.left) {
                if (current.right != null) stack.push(current.right);
            } else {
                stack.pop();
            }
            previous = current;
            if (stack.size() > maxDepth) maxDepth = stack.size();
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(maxDepthPostorderIterative(root));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
