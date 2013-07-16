import java.util.*;
public class Solution4Q4 {
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void inOrderCreateLevelLinkedList(TreeNode root, 
            ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        inOrderCreateLevelLinkedList(root.left, lists, level + 1);
        inOrderCreateLevelLinkedList(root.right, lists, level + 1);
    }

    public ArrayList<LinkedList<TreeNode>> inOrderCreateLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        inOrderCreateLevelLinkedList(root, lists, 0);
        return lists;
    }

    public ArrayList<LinkedList<TreeNode>> bfsCreateLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        // visit the root
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0){
            result.add(current); // add previous level
            LinkedList<TreeNode> parents = current;// go to next level
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                // visit the children
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}
