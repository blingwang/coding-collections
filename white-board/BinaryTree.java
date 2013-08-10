import java.util.*;
public class BinaryTree implements Iterable<TreeNode>{
        private TreeNode root;

        public BinaryTree(TreeNode root) {
                this.root = root;
        }
        
        @Override
        public Iterator<TreeNode> iterator() {
                return new InorderIterator(root);
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                BinaryTree bt = new BinaryTree(root);
                Iterator<TreeNode> it = bt.iterator();
                
                while (it.hasNext()) {
                        System.out.println(it.next().val);
                }
        }
        
        private class InorderIterator implements Iterator<TreeNode> {
                TreeNode current;
                ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
                
                public InorderIterator(TreeNode root) {
                        current = root;
                }
                
                @Override 
                public boolean hasNext() {
                        return current != null || !stack.isEmpty();
                }
                
                @Override
                public TreeNode next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        
                        while (current != null) {
                                stack.push(current);
                                current = current.left;
                        }
                        
                        TreeNode next = stack.pop();
                        current = next.right;
                        
                        return next;
                }
                
                @Override
                public void remove() {
                        throw new UnsupportedOperationException();
                }
        }
}

class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        
        public TreeNode(int val) {
                this.val = val;
        }
}
