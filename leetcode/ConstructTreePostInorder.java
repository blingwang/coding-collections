public class ConstructTreePostInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, 
                               int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd || postStart < 0) return null;
        
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        int inorderIndex = searchArray(inorder, inStart, inEnd, rootVal);
        int leftSubTreeSize = inorderIndex - inStart;
        
        root.left = buildTree(inorder, inStart, inorderIndex-1,
                              postorder, postStart, postStart+leftSubTreeSize-1);
                  
        root.right = buildTree(inorder, inorderIndex+1, inEnd,
                               postorder, postStart+leftSubTreeSize, postEnd-1);
        
        return root;
    }

    private int searchArray(int[] a, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (a[i] == target) return i;
        }
        
        return -1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
