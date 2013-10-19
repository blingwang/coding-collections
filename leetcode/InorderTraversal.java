import java.util.*;
public class InorderTraversal {
   public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode current = root; // current node to visit
        
        while (true) {
            while (current != null) {// got to left end
                stack.push(current);
                current = current.left;
            }
            
            if (stack.isEmpty()) break; // done
            
            // visit parent: not to visit left for nodes from stack
            // always pop when cur is null(left end or right end)
            current = stack.pop(); 
            result.add(current.val);
            current = current.right; // visit right substree
        }
        
        return result;
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
