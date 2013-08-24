public class Solution4Q8 { 
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        
        return subTree(t1,t2);
    }

    private static boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        }

        if (r1.val == r2.val && matchTree(r1, r2)) {
            return true;
        }

        return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    private static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.val != r2.val) {
            return false;
        }

        return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
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
        System.out.println(containsTree(bst, root));
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
