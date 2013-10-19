import java.util.*;
public class UniqueBSTs2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        return genSubTrees(1, n);
    }
    
    private ArrayList<TreeNode> genSubTrees(int start, int end) {
        ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
        if (start > end) trees.add(null);
        
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> lefts = genSubTrees(start, i - 1);
            ArrayList<TreeNode> rights = genSubTrees(i + 1, end);
            
            for(TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
            
        }
        
        return trees;
    }
    
    public ArrayList<TreeNode> generateTreesDP(int n) {
        if (n < 1) {
            ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
            trees.add(null);
            return trees;
        }
        
        ArrayList<ArrayList<ArrayList<TreeNode>>> allTreesTable = new ArrayList<ArrayList<ArrayList<TreeNode>>>();
        
        for (int i = 1; i <= n; i++) {
            ArrayList<TreeNode> singleNodeTrees = new ArrayList<TreeNode>();
            singleNodeTrees.add(new TreeNode(i));
            ArrayList<ArrayList<TreeNode>> equalRootTreesList = new ArrayList<ArrayList<TreeNode>>();
            equalRootTreesList.add(singleNodeTrees);
            allTreesTable.add(equalRootTreesList);
        }
        
        for (int size = 2; size <= n; size++) { // size of tree
            for (int i = 1; i <= n - size + 1 ; i++) { // start num of range
                ArrayList<TreeNode> currentSizeTrees = new ArrayList<TreeNode>();
                for (int j = i; j <= i + size - 1; j++) { // root num
                    if (j == i) {
                        ArrayList<TreeNode> rights = allTreesTable.get(j).get(i+size-j-2); // j+1~i+size-1
                        for (TreeNode right : rights) {
                            TreeNode root = new TreeNode(j);
                            root.right = right;
                            currentSizeTrees.add(root);
                        }
                    } else if (j == i + size -1) {
                        ArrayList<TreeNode> lefts = allTreesTable.get(i-1).get(j-i-1); // i~j-1
                        for (TreeNode left : lefts) {
                            TreeNode root = new TreeNode(j);
                            root.left = left;
                            currentSizeTrees.add(root);
                        }
                    } else {
                        ArrayList<TreeNode> lefts = allTreesTable.get(i-1).get(j-i-1); // i~j-1
                        ArrayList<TreeNode> rights = allTreesTable.get(j).get(i+size-j-2); // j+1~i+size-1
                        for (TreeNode left : lefts) {
                            for (TreeNode right : rights) {
                                TreeNode root = new TreeNode(j);
                                root.left = left;
                                root.right = right;
                                currentSizeTrees.add(root);
                            }
                        }
                    }
                }
                
                allTreesTable.get(i-1).add(currentSizeTrees);
            }
        }
        
        return allTreesTable.get(0).get(n-1);
    }
    
    int count;
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
