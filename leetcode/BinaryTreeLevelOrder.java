import java.util.*;

public class BinaryTreeLevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
        if (root == null) return levelList;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        int currentCount = 0;
        int nextCount = 0;
        
        queue.offer(root);
        nextCount++;
        
        while (!queue.isEmpty()) {
            if (currentCount == 0) {
                currentCount = nextCount;
                nextCount = 0;
                levelList.add(new ArrayList<Integer>());
            }
            
            TreeNode node = queue.poll();
            currentCount--;
            
            ArrayList<Integer> currentLevel = levelList.get(levelList.size() - 1);
            currentLevel.add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                nextCount++;
            }
            
            if (node.right != null) {
                queue.offer(node.right);
                nextCount++;
            }
        }
        
        return levelList;
    }
    
    // preorder DFS: T(k) = 2T(k-1) + c, k=lgn
    // DFS use less memory since height is limited
    // time complexity is still O(n): 1+3+7+...+2^k-1, k=lgn
    public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
        dfs(root, levelList, 0);
        return levelList;
    }
    
    private void dfs(TreeNode root, ArrayList<ArrayList<Integer>> levelList, int level) {
        if (root == null) return;
        
        if (level >= levelList.size()) {
            levelList.add(new ArrayList<Integer>());
        }
        
        ArrayList<Integer> curLevel = levelList.get(level);
        curLevel.add(root.val);
        
        dfs(root.left, levelList, level+1);
        dfs(root.right, levelList, level+1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
