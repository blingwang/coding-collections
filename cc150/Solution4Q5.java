public class Solution4Q5 { 
    public static boolean isBST(TreeNode root) {
//        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
//        return isBSTInOrder(root, pre);
        return inRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBSTInOrder(TreeNode root, TreeNode pre) {
        if (root == null) return true;
        
        if (!isBSTInOrder(root.left, pre)) return false;       
        if (pre.val >= root.val) return false;
        pre.val = root.val; // don't pre = root: pre is local var   
        if (!isBSTInOrder(root.right, pre)) return false;
        
        return true;
    }
    
    private static boolean inRange(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        return inRange(root.left, min, root.val) && inRange(root.right, root.val, max);
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
        System.out.println(isBST(bst));
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
