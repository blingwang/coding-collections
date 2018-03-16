class Node {
    String name;
    List<Node> neighors;
}

class ConnectedServers {
    public boolean isConnected(Node server1, Node server2) {
        Set<String> visited = new HashSet<String>(); // pass it around to make it thread safe
        return dfs(server1, server2, visited);    
    }
    
    private boolean dfs(Node src, Node dest, Set<String> visited) {
         visited.add(src.name);
         if (src.name.equals(dest.name)) {
             return true;
         }
         
         for (Node neighbor : src.neighbors) {
             if (!visited.contains(neighbor.name) && dfs(neighbor, dest)) {
                 return true;
             }
         }  
         
         return false;
    }
    
}
