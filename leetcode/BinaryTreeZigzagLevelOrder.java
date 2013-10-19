import java.util.*;
public class BinaryTreeZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
        if (root == null) return levelList;
        
        // adjacent levels nodes are visited in reverse order: use stack
        ArrayDeque<TreeNode> currentLevel = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<TreeNode>();
        boolean leftToRight = false; // 2nd level: push left to right, pop right to left
        
        nextLevel.offer(root);
        
        while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
            if (currentLevel.isEmpty()) {
                ArrayDeque<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                leftToRight = !leftToRight;
                levelList.add(new ArrayList<Integer>());
            }
            
            TreeNode node = currentLevel.pop();
            ArrayList<Integer> currentList = levelList.get(levelList.size() - 1);
            currentList.add(node.val);
            
            if (leftToRight) {
                if (node.left != null) nextLevel.push(node.left);
                if (node.right != null) nextLevel.push(node.right);
            } else {
                if (node.right != null) nextLevel.push(node.right);
                if (node.left != null) nextLevel.push(node.left);
            }
        }
        
        return levelList;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
