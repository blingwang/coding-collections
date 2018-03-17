/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static class MutableInt {
        int val;
        MutableInt(int val) {
            this.val = val;
        }
    }
    
    /**
     * A path from start to end, goes up on the tree for 0 or more steps, 
     * then goes down for 0 or more steps. Once it goes down, it can’t go up. 
     * Each path has a highest node, which is also the lowest common ancestor 
     * of all other nodes on the path.
     */    
    public int maxPathSum(TreeNode root) {
        MutableInt maxValue = new MutableInt(Integer.MIN_VALUE);
        maxPathDown(root, maxValue);
        return maxValue.val;
    }
    
    /**
     * A recursive method maxPathDown(TreeNode node) 
     * (1) computes the maximum path sum with highest node is the input node, update maximum if necessary 
     * (2) returns the maximum sum of the path that can be extended to input node’s parent.
     */
    private int maxPathDown(TreeNode root, MutableInt maxValue) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathDown(root.left, maxValue));
        int right = Math.max(0, maxPathDown(root.right, maxValue));
        maxValue.val = Math.max(maxValue.val, left + root.val + right);
        return Math.max(left, right) + root.val;
    }
}
