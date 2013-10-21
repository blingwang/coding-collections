import java.util.*;
public class RecoverBST {
    public void recoverTree(TreeNode root) {
        TreeNode[] swappedPair = new TreeNode[2];
        inorder(root, swappedPair, null);
        swapValues(swappedPair[0], swappedPair[1]);
    }
    
    // [1, 4, 3, 2, 5]: larger one in first inverted pair and smaller in the second pair
    // [1, 3, 2, 4, 5]: the only inverted pair is the two elements we are looking for
    // in-order traversal and return the last visited node in the traversal
    private TreeNode inorder(TreeNode root, TreeNode[] swappedPair, TreeNode pre) {
        if (root == null) return pre;
        pre = inorder(root.left, swappedPair, pre);
        
        if (pre != null && root.val < pre.val) {
            if (swappedPair[0] == null) {
                swappedPair[0] = pre;
                swappedPair[1] = root;
            } else {
                swappedPair[1] = root;
                return root;
            }
        }
        
        pre = root;
        
        return inorder(root.right, swappedPair, pre);
    }
    
    private void swapValues(TreeNode p, TreeNode q) {
        if (p == null || q == null) return;
        int temp= p.val;
        p.val = q.val;
        q.val = temp;
    }
    
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
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
