import java.util.Stack;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(Node left, Node right, int value){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft(){return left;}
    public Node getRight(){return right;}
    public int getValue(){return value;}
    
    // BST
    Node findNode(Node root, int value){
        if(root == null)
            return null;
        if(value == root.getValue())
            return root;
        if(value < root.getValue())
            return findNode(root.getLeft(), value);
        else 
            return findNode(root.getRight(), value);
    }

    // BST
    Node findLowestCommonAncester(Node root, int value1, int value2){
        while(root != null){
            int value = root.getValue();
            if(value > value1 && value > value2){
                root = root.getLeft();
            }else if(value < value1 && value < value2){
                root = root.getRight();
            }else{
                return root;
            }
        }
        return null;
    }

    // BST
    Node findLowestCommonAncester(Node root, Node child1, Node child2){
        if(root == null || child1 == null || child2 == null)
            return null;

        return findLowestCommonAncester(root, child1.getValue(), child2.getValue()); 
    }

    public static int treeHeight(Node n){
        if(n == null)
            return 0;
        return 1 + Math.max(treeHeight(n.getLeft()), treeHeight(n.getRight()));
    }

    void printValue(){
        System.out.println(this.getValue());
    }

    void preorderTraversal(Node root){
        if(root == null) return;
        root.printValue();
        preorderTraversal(root.getLeft());
        preorderTraversal(root.getRight());
    }

    void preorderTraversal_nonrecur(Node root){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(stack.size() > 0){
            Node cur = stack.pop();
            if(cur != null){
                cur.printValue();
                stack.push(cur.getRight());
                stack.push(cur.getLeft());
            }
        }
    }

    void inorderTraversal(Node root){
        if(root == null) return;
        inorderTraversal(root.getLeft());
        root.printValue();
        inorderTraversal(root.getRight());
    }

    void postorderTraversal(Node root){
        if(root == null) return;
        postorderTraversal(root.getLeft());
        postorderTraversal(root.getRight());
        root.printValue();
    }
    
    public static Node heapifyBinaryTree(Node root){
        int size = traverse(root, 0, null); // count nodes
        Node[] nodeArray = new Node[size];
        traverse(root, 0, nodeArray); // load nodes into array

        // sort array of nodes based on their values, using Comparator object
        Arrays.sort(nodeArray, new Comparator<Node>(){
            @override public int compare(Node m, Node n){
                int mv = m.getValue(), nv = n.getValue();
                return (mv < nv ? -1 : (mv == nv ? 0 : 1));
            }
        });

        // Reassign children for each node
        for(int i = 0; i < size; i++){
            int left = 2*i + 1;
            int right = 2*i + 2;
            nodeArray[i].setLeft(left >= size ? null : nodeArray[left]);
            nodeArray[i].setRight(right >=size? null : nodeArray[right]);
        }
        return nodeArray[0];
    } 
    
    // count nodes and put them in array
    public static int traverse(Node node, int count, Node[] arr){
        if(node == null)
            return count;
        if(arr != null)
            arr[count] = node;
        count++;
        count = traverse(node.getLeft(), count, arr);
        count = traverse(node.getRight(), count, arr);
        return count;
    }
    
    public Node rotateRight(){
        Node newRoot = left;
        left = newRoot.right;
        newRoot.right = this;
        return newRoot;
    }
}
