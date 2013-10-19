import java.util.*;

public class BottomUpLevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
        preOrder(root, levelList, 0);
        Collections.reverse(levelList);
        return levelList;
    }
    
    private void preOrder(TreeNode root, ArrayList<ArrayList<Integer>> levelList, int level) {
        if (root == null) return;
        if (level >= levelList.size()) {
            levelList.add(new ArrayList<Integer>());
        }
        
        ArrayList<Integer> currentLevel = levelList.get(level);
        currentLevel.add(root.val);
        
        preOrder(root.left, levelList, level + 1);
        preOrder(root.right, levelList, level + 1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
