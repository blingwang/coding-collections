import java.util.*;

public class PathSum2 {
    ArrayList<ArrayList<Integer>> paths;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curPath = new ArrayList<Integer>();
        dfs(root, curPath, sum);
        return paths;
    }

    private void dfs(TreeNode root, ArrayList<Integer> curPath, int sum) {
        if (root == null) return;
        
        curPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ArrayList<Integer> found = new ArrayList<Integer>();
            found.addAll(curPath);
            paths.add(found);
            curPath.remove(curPath.size() - 1);
            return;
        }
        
        dfs(root.left, curPath, sum - root.val);
        dfs(root.right, curPath, sum - root.val);
        
        curPath.remove(curPath.size() - 1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
