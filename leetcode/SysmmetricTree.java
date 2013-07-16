public class SysmmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        //mirror(root.left);
        return isMirror(root.left, root.right);     
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        return p.val == q.val && isMirror(p.right, q.left) && isMirror(p.left, q.right);
    }
    
    private boolean isMirrorIter(TreeNode left, TreeNode right) {
        if ( left == null && right == null) return true;
        if ( left == null || right == null) return false;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            
            if (p.val != q.val) return false;
            
            if ((p.left == null && q.right != null) || 
                 (p.left != null && q.right == null)) {
                    return false;
            } 
            if (p.left != null && q.right != null) {
                queue.offer(p.left);
                queue.offer(q.right);
            }
            
            if ((p.right == null && q.left != null) || 
                 (p.right != null && q.left == null)) {
                    return false;
            } 
            if (p.right != null && q.left != null) {
                queue.offer(p.right);
                queue.offer(q.left);
            }
        }
        
        return true;
    }

    private void mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
