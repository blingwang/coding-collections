/**
 * Definition for undirected graph.
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> copyTable = new HashMap<Integer, UndirectedGraphNode>();
        return clone(node, copyTable);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> copyTable) {
        if (node == null) return null;
        if (copyTable.containsKey(node.label)) return copyTable.get(node.label);
        
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        copyTable.put(node.label, copy);
        
        for (UndirectedGraphNode n : node.neighbors) {
            copy.neighbors.add(clone(n, copyTable));
        }
        
        return copy;
    }
}
