public class ConstructTreePreInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);    
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, 
                               int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || preEnd >= preorder.length) return null;
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        int inorderIndex = searchArray(inorder, inStart, inEnd, rootVal);
        int leftSubTreeSize = inorderIndex - inStart;
        
        root.left = buildTree(preorder, preStart+1, preStart+leftSubTreeSize,
                              inorder, inStart, inorderIndex-1);
                  
        root.right = buildTree(preorder, preStart+leftSubTreeSize+1, preEnd,
                               inorder, inorderIndex+1, inEnd);
        
        return root;
    }

    private int searchArray(int[] a, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (a[i] == target) return i;
        }
        
        return -1;
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
