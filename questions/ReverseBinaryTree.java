/* Reverse a binary tree

        4
       / \
      8   5
     /\  / \
    1 5  1 7
*/
Class Node {
    int val;
    Node left;
    Node right;
    
    Node(int value){
        val = value;
    }
}

Node reverseBinaryTree(Node root) {
    if (root == null) {
        return root;
    }
    
    Node left = root.left;
    Node right = root.right;
    
    root.left = reverseBinaryTree(right);
    root.right = reverseBinaryTree(left);
    
    return root;
}
