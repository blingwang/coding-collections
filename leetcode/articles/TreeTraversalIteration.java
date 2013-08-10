import java.util.*;
/**
 * simulate recursive call stack
 * use stack to store dfs path so far
 */
public class TreeTraversalIteration {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        if (root == null) return values;

        ArrayDeque<TreeNode> stack =  new ArrayDeque<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            values.add(current.val);
            
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return values;
    }

    public static ArrayList<Integer> preorderMorrisTraversal(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        if (root == null) return values;

        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {// find left most end
                values.add(current.val);
                current = current.right;
            } else {
                TreeNode pre = current.left; // inorder predecessor of current
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {//make current right child of its predecessor
                    values.add(current.val);
                    pre.right = current;
                    current = current.left;
                } else {// revert changes
                    pre.right = null;
                    current = current.right;
                }
            }
        }

        return values;
    }

    public static  ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode current = root;

        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            } 
            
            if (stack.isEmpty()) break; // done
            
            // always pop when cur is null(left end or right end)
            current = stack.pop();
            values.add(current.val);
            current = current.right;
        }

        return values;
    }

    // to do in-order traversal without recursion nor a stack
    // we can either use a parent pointer or threaded tree
    public static ArrayList<Integer> inorderTraversalWithParent(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        TreeNode current = root;
        TreeNode previous = null;

        while (current != null) {
            if (previous == current.parent) {//Traversing down the tree
                previous = current;
                if (current.left != null) {//down to left
                    current = current.left;
                } else {
                    values.add(current.val);
                    if (current.right != null) current = current.right;//down to right
                    else current = current.parent;// up
                }
            } else if (previous == current.left) {//Traversing up the tree from left
                previous = current;
                values.add(current.val);
                if (current.right != null) current = current.right;
                else current = current.parent;
            } else if (previous == current.right) {//Traversing up the tree from right
                previous = current;
                current = current.parent;
            }
        }
        return values;
    }

    public static ArrayList<Integer> inorderMorrisTraversal(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        if (root == null) return values;

        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {// find left most end
                values.add(current.val);
                current = current.right;
            } else {
                TreeNode pre = current.left; // inorder predecessor of current
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {//make current right child of its predecessor
                    pre.right = current;
                    current = current.left;
                } else {// revert changes
                    pre.right = null;
                    values.add(current.val);
                    current = current.right;
                }
            }
        }

        return values;
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) { 
        ArrayList<Integer> values = new ArrayList<Integer>();
        if (root == null) return values;
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();// store dfs path
        stack.push(root);
        TreeNode previous = null;

        while (!stack.isEmpty()) {//redundant code can be refactored: group 'up' cases
            TreeNode current = stack.peek();
            if (previous == null || previous.left == current || 
                previous.right == current) {//Traversing down
                if (current.left != null) {//down to left
                    stack.push(current.left);
                } else if (current.right != null) {// down to right
                    stack.push(current.right);
                } else {//no left and right: up
                    values.add(current.val);
                    stack.pop();
                }
            } else if (previous == current.left) {//Traversing up from left
                if (current.right != null) {// down to right
                    stack.push(current.right);
                } else {//no right: up
                    values.add(current.val);
                    stack.pop();
                }
            } else if (previous == current.right) {//Traversing up from right
                values.add(current.val);
                stack.pop();
            }
            previous = current;
        }
        return values;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.parent = root;
        root.right = new TreeNode(5);
        root.right.parent = root;
        root.left.left = new TreeNode(1);
        root.left.left.parent = root.left;
        root.left.right = new TreeNode(3);
        root.left.right.parent = root.left;

        ArrayList<Integer> inorderValues = inorderMorrisTraversal(root);
        for (int i : inorderValues) {
            System.out.print(i);
        }
        System.out.println();

        ArrayList<Integer> preorderValues = preorderMorrisTraversal(root);
        for (int i : preorderValues) {
            System.out.print(i);
        }
        System.out.println();

        ArrayList<Integer> postorderValues = postorderTraversal(root);
        for (int i : postorderValues) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
