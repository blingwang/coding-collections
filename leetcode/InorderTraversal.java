import java.util.*;
public class InorderTraversal {
   public ArrayList<Integer> inorderTraversal(TreeNode root) {
       ArrayList<Integer> values = new ArrayList<Integer>();
       ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
       TreeNode current = root;
       
       while (true) {
           while (current != null) {
               stack.push(current);
               current = current.left;
           } 
           
           if (stack.isEmpty()) break;
           
           current = stack.pop();
           values.add(current.val);
           current = current.right;
       }
       
       return values;
   }
   
   public ArrayList<Integer> inorderTraversalRecur(TreeNode root) {
       ArrayList<Integer> values = new ArrayList<Integer>();
       inorderTraversal(values, root);
       return values;
   }
   
   private void inorderTraversal(ArrayList<Integer> values, TreeNode root) {
       if (root == null) return;
       inorderTraversal(values, root.left);
       values.add(root.val);
       inorderTraversal(values, root.right);
   }

   private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
