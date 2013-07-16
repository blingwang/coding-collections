public class BalancedBinaryTree {
   public boolean isBalanced(TreeNode root) {
       return isBalancedBottomUp(root);
   }
   
   public boolean isBalancedBottomUp(TreeNode root) {
       return checkHeight(root) >= 0;
   }
   
   public int checkHeight(TreeNode root) {
       if (root == null) return 0;
       
       int leftHeight = checkHeight(root.left);
       if (leftHeight < 0) return -1;
       int rightHeight = checkHeight(root.right);
       if (rightHeight < 0) return -1;
       
       if (Math.abs(leftHeight - rightHeight) > 1) return -1;
       
       return Math.max(leftHeight, rightHeight) + 1;
   }
   
   public boolean isBalancedTopDown(TreeNode root) {
       if (root == null) return true;
       
       int leftHeight = getHeight(root.left);
       int rightHeight = getHeight(root.right);
       
       return isBalanced(root.left) && isBalanced(root.right) && 
              Math.abs(leftHeight - rightHeight) <= 1;
   }
   
   private int getHeight(TreeNode root) {
       if (root == null) return 0;
       return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
   }
   
   private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
