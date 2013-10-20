import java.util.*;

public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPathSum(root, sum, path, result);
        return result;
    }
    
    private void findPathSum(TreeNode root, int sum, ArrayList<Integer> path, 
                             ArrayList<ArrayList<Integer>> result) {
        if (root == null) return;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(path));
        }
        
        findPathSum(root.left, sum - root.val, path, result);
        findPathSum(root.right, sum - root.val, path, result);
        
        path.remove(path.size() - 1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
