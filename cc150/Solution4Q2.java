import java.util.*;
public class Solution4Q2 {
    private class Node {
        private int data;
        State state;
        private ArrayList<Node> neighbors;

        public Node(int data) {
            this.data = data;
            neighbors = new ArrayList<Node>();
        }

        public ArrayList<Node> getAdjacent() {
            return neighbors;
        }
    }

    private class Graph {
        private ArrayList<Node> nodes;
        public Graph() {
            nodes = new ArrayList<Node>();
        }

        public void addNode(Node n) {
            nodes.add(n);
        }

        public ArrayList<Node> getNodes() {
            return nodes;
        }
    }

    enum State {
        Unvisited, Visited, Visiting;
    }

    public static boolean bfsPathSearch(Graph g, Node start, Node end) {
        LinkedList<Node> q = new LinkedList<Node>();

        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);

        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if(u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}
