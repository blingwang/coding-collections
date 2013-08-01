public interface Node {
	Node left();
	Node right();
}

/**
 * Auxilliary class for use in getDeepestNode
 */
public class NodeDepth {
  	Node node;
  	int depth;
  
  	public NodeDepth(Node node, int depth) {
	    this.node = node;
	    this.depth = depth;
	}

	public int getDepth() {
    		return depth;
	}
}

public NodeDepth getDeepestNode(Node root) {
	return getDeepestNode(root, 1);
}

private NodeDepth getDeepestNode(Node root, int depth) {
	if (root == null) return null;
  
  	NodeDepth left = getDeepestNode(root.left, depth + 1);
	NodeDepth right = getDeepestNode(root.right, depth + 1);
  
	if (left == null && right == null) return new NodeDepth(root, depth);
	if (left == null) return right; 
	if (right == null) return left;
  
	return (left.getDepth() > right.getDepth()) ? left : right;
}

// test cases
null ->	null
root=1 -> (1, 1)
root=1, root.left = 2 -> (2, 2)
root = 1, root.left = 2, root.right = 3 ->	(3,2);
root = 1, root.left = 2, root.left.left = 3 -> (3, 3)
root = 1, root.right = 2, root.right.right = 3 -> (3, 3)

@Test
public void testDeepestNodeDepth() {
	// … build tree
	NodeDepth deepest = getDeepestNode(root);
	assertEquals(deepest.getDepth(), 3);
	assertEquals(deepest.getNode().val, 3);
}
