public class Solution4Q9 {
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void findSum(TreeNode node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }

        // insert current node into path
        path[level] = node.data;

        // look for paths with a sum that ends at this node
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += path[i];
            if (t == sum) {
                print(path, i, level);
            }
        }

        //search nodes beneath this one
        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

        // not strictly necessary
        path[level] = Integer.MIN_VALUE;
    }

    public void findSum(TreeNode node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }

    public void print(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
