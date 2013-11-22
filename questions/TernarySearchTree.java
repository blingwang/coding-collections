import java.util.*;

public class TernarySearchTree {
    private Node root;

    private class Node {
	private int value;
	private Node left, middle, right;

	public Node(int value) {
	    this.value = value;
	}
    }

    public void insert(int value) {
	root = insert(root, value);
    }

    private Node insert(Node node, int value) {
	if (node == null) {
	    return new Node(value);
	}

	if (value < node.value) {
	    node.left = insert(node.left, value);
	} else if (value > node.value) {
	    node.right = insert(node.right, value);
	} else {
	    node.middle = insert(node.middle, value);
	}

	return node;
    }

    public void delete(int value) {
	root = delete(root, value);
    }

    /*
     * deletes all nodes with target value
     * if no left or right subtrees: set this node to null
     * if only left substree: replace this node with left node
     * if only right subtree: replace this node with right node
     * if both left and right subtrees: replace this node with
     * the minimum value node in the right substree
     */
    private Node delete(Node node, int value) {
	if (node == null) {
	    return null; // no such value
	}

	if (value < node.value) {
	    node.left = delete(node.left, value);
	} else if (value > node.value) {
	    node.right = delete(node.right, value);
	} else {
	    if (node.right == null) {
		return node.left;
	    }

	    if (node.left == null) {
		return node.right;
	    }

	    Node oldNode = node;
	    node = min(oldNode.right);
	    node.right = deleteMin(oldNode.right);
	    node.left = oldNode.left;
	}

	return node;
    }

    private Node min(Node node) {
	if (node == null) {
	    return null;
	}

	if (node.left == null) {
	    return node;
	}

	return min(node.left);
    }

    private Node deleteMin(Node node) {
	if (node == null) {
	    return null;
	}

	if (node.left == null) {
	    return node.right;
	}

	node.left = deleteMin(node.left);
	return node;
    }

    public void printLevelOrder() {
	if (root == null) {
	    return;
	}

	ArrayDeque<Node> queue = new ArrayDeque<Node>();
	int currentCount = 0;
	int nextCount = 0;

	queue.offer(root);
	currentCount++;

	while (!queue.isEmpty()) {
	    Node current = queue.poll();
	    currentCount--;
	    System.out.print(current.value);

	    if (current.left != null) {
		queue.offer(current.left);
		nextCount++;
	    }

	    if (current.middle != null) {
		queue.offer(current.middle);
		nextCount++;
	    }

	    if (current.right != null) {
		queue.offer(current.right);
		nextCount++;
	    }

	    if (currentCount == 0) {
		currentCount = nextCount;
		nextCount = 0;
		System.out.println();
	    }
	}
    }

    public static void main(String[] args) {
	int[] a = {5, 4, 9, 5, 7, 2, 2};
	TernarySearchTree tst =new TernarySearchTree();

	for (int i : a) {
	    tst.insert(i);
	}

	tst.printLevelOrder();
	System.out.println();

	tst.delete(5);
	tst.printLevelOrder();
	System.out.println();

	tst.delete(9);
	tst.printLevelOrder();
	System.out.println();

	tst.delete(4);
	tst.printLevelOrder();
	System.out.println();

	tst.delete(0);
	tst.printLevelOrder();
    }
}
