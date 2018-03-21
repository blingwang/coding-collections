import java.util.*;

public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) return levelList;
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            levelList.add(curLevel);
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
