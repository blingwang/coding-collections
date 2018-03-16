Class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        
        int closest = root.val;
        while (root != null) {
            if (root.val == target) return root.val;
            
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }
}
