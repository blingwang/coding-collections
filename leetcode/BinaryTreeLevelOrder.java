import java.util.*;

public class BinaryTreeLevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int currentLevelNodes = 0;
        int nextLevelNodes = 1;

        while (!queue.isEmpty()) {
            if (currentLevelNodes == 0) {
                result.add(new ArrayList<Integer>());
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
            
            TreeNode node = queue.poll();
            currentLevelNodes--;

            ArrayList<Integer> list = result.get(result.size()-1);
            list.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                nextLevelNodes++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelNodes++;
            }
        }

        return result;
    }
    
    // DFS: T(k) = 2T(k-1) + c, k=lgn
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
