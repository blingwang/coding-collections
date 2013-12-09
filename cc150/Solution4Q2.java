import java.util.*;
public class Solution4Q2 {   
    public static boolean bfs(Node start, Node end) {
        assert(start != end);
        Queue<Node> queue = new ArrayDeque<Node>();
        Set<Node> marked = new HashSet<Node>();
        
        marked.add(start);
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            for (Node n : cur.getAdjacent()) {
                if (n == end) return true;
                
                if (!marked.contains(n)) {
                    queue.offer(n);
                    marked.add(n);
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Node start = new Node(1);
        Node end = new Node(2);
        start.neighbors.add(end);
        
        System.out.println(bfs(start, end));
    }
    
    private static class Node {
        private int val;
        private List<Node> neighbors;
        
        public Node(int x) {
            val = x;
            neighbors = new ArrayList<Node>();
        }
        
        public List<Node> getAdjacent() {
            return neighbors;
        }
    }
    
    private static class Graph {
        private List<Node> nodes;
        
        public Graph() {
            nodes = new ArrayList<Node>();
        }
        
        public void addNode(Node n) {
            nodes.add(n);
        }
        
        public List<Node> getNodes() {
            return nodes;
        }
    }
}
