class Solution17Q13 {
    public static Node treeToDoublyList(Node root) {
        Node pre = null;
        Node head = null;
        head = treeToDoublyList(root, pre, head);
        return head;
    }

    /* convert tree by inorder traversal */
    private static Node treeToDoublyList(Node node, Node pre, Node head) {
        if (node == null) return head;
        
        // convert left
        head = treeToDoublyList(node.small, pre, head);

        // update links between pre and current node
        node.small = pre;
        if (pre != null) {
            pre.large = node;
        } else {
            head = node;
        }

        Node large = node.large; // for later visit
       
        // update links between head and current node
        node.large = head;
        head.small = node;
        
        // update pre
        pre = node;

        // convert right
        head = treeToDoublyList(large, pre, head);

        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        TreeList.treeInsert(root, 2);
        TreeList.treeInsert(root, 1);
        TreeList.treeInsert(root, 3);
        TreeList.treeInsert(root, 5);

        System.out.println("tree:");
        TreeList.printTree(root);
        System.out.println();

        System.out.println("list:");
        Node head = TreeList.treeToList(root);
        TreeList.printList(head);
    }
}

class TreeList {
    // join two nodes
    public static void join(Node a, Node b) {
        a.large = b;
        b.small = a;
    }

    // append two circular doubly linked list
    public static Node append(Node a, Node b) {
        // if either is null, return the other
        if (a == null) return b;
        if (b == null) return a;

        // find the last node in each using the previous pointer
        Node aLast = a.small;
        Node bLast = b.small;

        // join heads and tails
        join(aLast, b);
        join(bLast, a);

        return a;
    }

    public static Node treeToList(Node root) {
        if (root == null) return null;

        Node aList = treeToList(root.small);
        Node bList = treeToList(root.large);

        // Make the single root node into a circular double linked list
        root.small = root;
        root.large = root;

        aList = append(aList, root);
        aList = append(aList, bList);

        return aList;
    }

    public static void treeInsert(Node root, int newData) {
        if (newData <= root.data) {
            if (root.small != null) {
                treeInsert(root.small, newData);
            } else {
                root.small = new Node(newData);
            }
        } else {
            if (root.large != null) {
                treeInsert(root.large, newData);
            } else {
                root.large = new Node(newData);
            }
        }
    }

    public static void printTree(Node root) {
        if (root == null) return;
        printTree(root.small);
        System.out.print(root.data + " ");
        printTree(root.large);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.large;
            if (current == head) break;
        }

        System.out.println();
    }
}

class Node {
    int data;
    Node small;
    Node large;

    public Node(int data) {
        this.data = data;
        small = null;
        large = null;
    }
}
    
