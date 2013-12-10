public class Solution4Q9 { 
    public static void findSum(TreeNode root, int sum) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        findSum(root, sum, path);
    }

    private static void findSum(TreeNode root, int sum, ArrayList<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        int curSum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            curSum += path.get(i);
            if (curSum == sum) {
                printPath(path, i, path.size() - 1);
            }
        }

        findSum(root.left, sum, path);
        findSum(root.right, sum, path);
    }

    private static void printPath(ArrayList<Integer> path, int start, int end) {
        assert (start >= 0 && end < path.size() && start <= end);
        for (int i = start; i <= end; i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
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
        findSum(bst, 7);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

        public void print() {
            System.out.print(val + " ");
            if (left != null) left.print();
            if (right != null) right.print();
        }
    }
}
