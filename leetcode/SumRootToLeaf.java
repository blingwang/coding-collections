public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    // DFS
    private int sumNumbers(TreeNode root, int curSum) {
        if (root == null) return 0; // don't return curSum
        
        curSum = curSum * 10 + root.val;
        
        // only return result if leaf node
        if (root.left == null && root.right == null) return curSum;
        
        return sumNumbers(root.left, curSum) + sumNumbers(root.right, curSum); 
    }

    // BFS
    private int sumNumbersBFS(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        ArrayDeque<Integer> sumQueue = new ArrayDeque<Integer>();
        queue.offer(root);
        sumQueue.offer(root.val);
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curSum = sumQueue.poll();
            
            if (cur.left == null && cur.right == null) sum += curSum;
            
            if (cur.left != null) {
                queue.offer(cur.left);
                sumQueue.offer(curSum * 10 + cur.left.val);
            }
            
            if (cur.right != null) {
                queue.offer(cur.right);
                sumQueue.offer(curSum * 10 + cur.right.val);
            }
        }
        
        return sum;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
