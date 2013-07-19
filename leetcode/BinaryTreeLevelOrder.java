import java.util.*;

public class BinaryTreeLevelOrder {
    ArrayList<ArrayList<Integer>> result;

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

    public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
        result = new ArrayList<ArrayList<Integer>>();
        // DFS use less memory since height is limited
        // time complexity is still O(n): 1+3+7+...+2^k-1, k=lgn
        inOrder(root, 0); 
        return result;
    }

    private void inOrder(TreeNode root, int level) { // T(k) = 2T(k-1) + c, k=lgn
        if (root == null) return;
        if (level >= result.size()) {
            ArrayList<Integer> levelNodes = new ArrayList<Integer>();
            result.add(levelNodes);
        }
        
        ArrayList<Integer> levelNodes = result.get(level);
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
