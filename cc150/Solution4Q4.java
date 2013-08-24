import java.util.*;

public class Solution4Q4 { 
    public static ArrayList<ArrayList<TreeNode>> getLevelLists(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> levels = new ArrayList<ArrayList<TreeNode>>();
        preOrder(root, 0, levels);
        return levels;
        //return bfs(root);
    }
    
    private static void preOrder(TreeNode root, int level, 
                                 ArrayList<ArrayList<TreeNode>> levels) {
        if (root == null) return;
        
        if (level == levels.size()) {
            levels.add(new ArrayList<TreeNode>());
        }
        
        ArrayList<TreeNode> curLevel = levels.get(level);
        curLevel.add(root);
        
        preOrder(root.left, level + 1, levels);
        preOrder(root.right, level + 1, levels);
    }

    private static ArrayList<ArrayList<TreeNode>> bfs(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> levelLists = new ArrayList<ArrayList<TreeNode>>();
        if (root == null) return levelLists;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int curLevelCount = 0;
        int nextLevelCount = 1;
        
        while (!queue.isEmpty()) {
            if (curLevelCount == 0) { // got to next level
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
                levelLists.add(new ArrayList<TreeNode>());
            }
            
            // visit next node in current level
            TreeNode cur = queue.poll();
            curLevelCount--;
            ArrayList<TreeNode> curLevel = levelLists.get(levelLists.size() - 1);
            curLevel.add(cur);
            
            // add children to next level
            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelCount++;
            }
            
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelCount++;
            }
        }       
        
        return levelLists;
    }
    
    public ArrayList<LinkedList<TreeNode>> bfsCreateLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) current.add(root); // visit the root

        while (!current.isEmpty()){
            // add previous level
            result.add(current);
            
            // visit next level
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
    
    public static TreeNode sortedArrayToBST(int[] a) {
        return sortedArrayToBST(a, 0, a.length - 1);
    }
    
    private static TreeNode sortedArrayToBST(int[] a, int lo, int hi) {
        if (lo > hi) return null;
        
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(a[mid]);
        
        root.left = sortedArrayToBST(a, lo, mid - 1);
        root.right = sortedArrayToBST(a, mid + 1, hi);
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bst = sortedArrayToBST(a);
        bst.print();      
        System.out.println();
        
        ArrayList<ArrayList<TreeNode>> levels = getLevelLists(bst);
        for (ArrayList<TreeNode> level : levels) {
            for (TreeNode n : level) {
                System.out.print(n.val);
            }
            System.out.println();
        }
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
        
        public void print() {
            System.out.print(val);
            if (left != null) left.print();
            if (right != null) right.print();
        }
    }
}
