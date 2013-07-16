import java.util.*;
public class UniqueBSTs2 {
    int count;
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    private ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> rootlist = new ArrayList<TreeNode>();
        if(start > end) rootlist.add(null);
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftRoots = generateTrees(start, i-1);
            ArrayList<TreeNode> rightRoots = generateTrees(i+1, end);
            for(TreeNode leftRoot : leftRoots) {
                for (TreeNode rightRoot : rightRoots) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    rootlist.add(root);
                }
            }
        }
        return rootlist;
    }
    
    public ArrayList<TreeNode> generateTreesIteration(int n) {
        ArrayList<TreeNode>[] bstLists = (ArrayList<TreeNode>[]) new ArrayList[n+1];       
        bstLists[0] = new ArrayList<TreeNode>();
        bstLists[0].add(null);
        
        for (int i = 1; i <= n; i++) {
            bstLists[i] = new ArrayList<TreeNode>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode leftNode : bstLists[j-1]) {
                    for (TreeNode rightNode : bstLists[i-j]) {                       
                        TreeNode root = new TreeNode(j);
                        root.left = leftNode;
                        root.right = rightNode;
                        bstLists[i].add(root);
                    }
                }
            }
        }
        
        return fillValues(bstLists[n]);
    }
    
    private ArrayList<TreeNode> fillValues(ArrayList<TreeNode> roots) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        for (TreeNode root : roots) {
            count = 0;
            list.add(inorderCopy(root));
        }
        
        return list;
    }
    
    private TreeNode inorderCopy(TreeNode root) {
        if (root == null) return null;
        TreeNode leftNode = inorderCopy(root.left);
        TreeNode copy = new TreeNode(++count);
        TreeNode rightNode = inorderCopy(root.right);
        copy.left = leftNode;
        copy.right = rightNode;
        return copy;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generateTrees(3);
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
