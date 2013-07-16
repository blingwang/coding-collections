import java.util.*;
public class RecoverBST {
    TreeNode first, second, pre;
    
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        pre = null;
        
        inorderSearchPivots(root);
        swapValue(first, second);
    }
    
    private void inorderSearchPivots(TreeNode root) {
        if (root == null) return;
        
        inorderSearchPivots(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
                second = root;
            } else {
                second = root;
                return;
            }
        }
        pre = root;
        inorderSearchPivots(root.right);
    }
    
    private void swapValue(TreeNode a, TreeNode b) {
        if (first == null || second == null) return;
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
