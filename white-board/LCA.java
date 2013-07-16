class LCA {
    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node searchBST(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            return root;
        }

        if (root.data < key) {
            return searchBST(root.right, key);
        }

        return searchBST(root.left, key);
    }

    public static Node LCA(Node root, Node p, Node q) {
        if (p == null || q == null) {
            return null;
        }

        while (root != null) {
            if (root.data > p.data && root.data > q.data) {
                root = root.left;
                continue;
            }

            if (root.data < p.data && root.data < q.data) {
                root = root.right;
                continue;
            }

            if (searchBST(root, p.data) != null && 
                searchBST(root, q.data) != null) {
                return root;
            } else {
                return null;
            }
        }

        return null;
    }
}

