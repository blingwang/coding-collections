import java.util.*;
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
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
