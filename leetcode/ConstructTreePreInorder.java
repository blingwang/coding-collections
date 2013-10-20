public class ConstructTreePreInorder {
    Map<Integer, Integer> inorderMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildSubTree(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildSubTree(int[] preorder, int preStart, 
                                  int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        int rootVal = preorder[preStart];
        int rootIndex = inorderMap.get(rootVal);
        int leftSubTreeSize = rootIndex - inStart;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = buildSubTree(preorder, preStart+1, inorder, inStart, rootIndex-1);
        root.right = buildSubTree(preorder, preStart+leftSubTreeSize+1, inorder, rootIndex+1, inEnd);
        
        return root;
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
