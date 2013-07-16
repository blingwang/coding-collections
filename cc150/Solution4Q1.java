public class Solution4Q1 {
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {// recur: good to have tail recursion
            return isBalanced1(root.left) && isBalanced1(root.right);
        }
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // check if left is balanced
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        // check if right is balanced
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        // check if current node is balanced
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced2(TreeNode root) {
       return checkHeight(root) == -1;
    }
} 
