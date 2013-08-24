public class Solution4Q6 { 
    // if bst root is known, we can go top down to find ceiling(n)
    public static TreeNode inOrderSucc(TreeNode n) {
        if (n == null) return null;
        if (n.right != null) return leftMost(n.right);
        
        // Go up until current node is left child of parent
        TreeNode p = n.parent;
        while (p != null && p.left != n) {
            n = p;
            p = p.parent;
        }
        
        return p;
    }
    
    private static TreeNode leftMost(TreeNode root) {
        if (root == null) return null;
        while (root.left != null) root = root.left;
        return root;
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
        root.left.parent = root;
        root.right.parent = root;
        
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bst = sortedArrayToBST(a);
        bst.print();   
        System.out.println();
        System.out.println(inOrderSucc(root.left).val);
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
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
