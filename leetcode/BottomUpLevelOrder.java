import java.util.*;

public class BottomUpLevelOrder {
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        result = new ArrayList<ArrayList<Integer>>();
        inOrder(root, 0); 
        return result;
    }

    private void inOrder(TreeNode root, int level) {
        if (root == null) return;
        if (level >= result.size()) {
            ArrayList<Integer> levelNodes = new ArrayList<Integer>();
            result.add(0, levelNodes);
        }
        
        ArrayList<Integer> levelNodes = result.get(result.size() - level - 1);
        levelNodes.add(root.val);
        inOrder(root.left, level+1);
        inOrder(root.right, level+1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
