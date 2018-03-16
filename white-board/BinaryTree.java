import java.util.*;
public class BinaryTree implements Iterable<TreeNode>{
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }
    
     
    public void delete(Key key) {  root = delete(root, key);  }
    
    private Node delete(Node x, Key key) {
       if (x == null) return null;
       int cmp = key.compareTo(x.key);
       if      (cmp < 0) x.left  = delete(x.left,  key);
       else if (cmp > 0) x.right = delete(x.right, key);
       else {
          if (x.right == null) return x.left;
          if (x.left == null) return x.right;
          Node t = x;
          x = min(t.right);
          x.right = deleteMin(t.right);
          x.left = t.left;
       }
       return x;
    }
    
    public void deleteMin() {  root = deleteMin(root);  }
    
    private Node deleteMin(Node x){
       if (x.left == null) return x.right;
       x.left = deleteMin(x.left);
       x.count = 1 + size(x.left) + size(x.right);
       return x;
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
        private TreeNode current;
        private ArrayDeque<TreeNode> stack;
        
        public InorderIterator(TreeNode root) {
            current = root;
            stack = new ArrayDeque<TreeNode>();
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
