/**
 * Definition for undirected graph.
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> copyTable = new HashMap<>();
        
        UndirectedGraphNode graphCopy = new UndirectedGraphNode(node.label);
        copyTable.put(node.label, graphCopy);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            UndirectedGraphNode currentCopy = copyTable.get(current.label);
            
            for (UndirectedGraphNode n : current.neighbors) { // visit edge
                if (!copyTable.containsKey(n.label)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
                    currentCopy.neighbors.add(copy);
                    copyTable.put(n.label, copy);
                    queue.offer(n);
                } else {
                    UndirectedGraphNode copy = copyTable.get(n.label);
                    currentCopy.neighbors.add(copy);
                }
            }
        }
        
        return graphCopy;
    }
    
    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> copies = new HashMap<>();
        return clone(node, copies);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> copies) {
        if (copies.containsKey(node.label)) return copies.get(node.label);
        
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        copies.put(node.label, copy);
        
        for (UndirectedGraphNode n : node.neighbors) {
            copy.neighbors.add(clone(n, copies));
        }
        
        return copy;
    }
}
