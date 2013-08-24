public class Solution4Q1 {   
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        if (Math.abs(left - right) > 1) return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
       
        return Math.max(getHeight(root.left), getHeight(root.left)) + 1;
    }
    
    public static boolean isBalancedBU(TreeNode root) {
        return checkHeight(root) > 0;
    }
    
    private static int checkHeight(TreeNode root) {
        if (root == null) return 0;
        
        int left = checkHeight(root.left);
        if (left < 0) return -1;
        
        int right = checkHeight(root.right);
        if (right < 0) return -1;
        
        if (Math.abs(left - right) > 1) return -1;
        
        return Math.max(left, right) + 1;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        System.out.println(isBalancedBU(root));
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
