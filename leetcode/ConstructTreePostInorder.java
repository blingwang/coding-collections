public class ConstructTreePostInorder {
    Map<Integer, Integer> inorderMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildSubTree(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }
    
    private TreeNode buildSubTree(int[] inorder, int inStart, int inEnd, 
                               int[] postorder, int postEnd) {
        if (inStart > inEnd) return null;
        
        int rootVal = postorder[postEnd];
        int rootIndex = inorderMap.get(rootVal);
        int rightSubTreeSize = inEnd - rootIndex;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = buildSubTree(inorder, inStart, rootIndex-1, postorder, postEnd-rightSubTreeSize-1);
        root.right = buildSubTree(inorder, rootIndex+1, inEnd, postorder, postEnd-1);
        
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
