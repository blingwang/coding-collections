import java.util.*;
public class BinaryTreeZigzagLevelOrder {
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        
        ArrayDeque<TreeNode> currentLevel = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<TreeNode>();   
        boolean leftToRight = true;
        nextLevel.add(root);
        
        while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
            if (currentLevel.isEmpty()) {
                ArrayDeque<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                leftToRight = !leftToRight;
                result.add(new ArrayList<Integer>());
            }
            
            TreeNode node = currentLevel.pop();
            ArrayList<Integer> list = result.get(result.size()-1);
            list.add(node.val);
            
            if (leftToRight) {
                if (node.right != null) nextLevel.push(node.right);
                if (node.left != null) nextLevel.push(node.left);
            } else {
                if (node.left != null) nextLevel.push(node.left);
                if (node.right != null) nextLevel.push(node.right);
            }
            
        }
        
        return result;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
