class Solution {
    private boolean[] marked;
    private boolean[] onStack;
    private Deque<Integer> reversePost;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // return bfs(numCourses, prerequisites);
        ArrayList<Integer>[] graph = makeGraph(numCourses, prerequisites);
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        reversePost = new ArrayDeque<Integer>();
        
        for (int i = 0; i < numCourses; i++) {
            if (!marked[i] && !dfs(graph, i)) {
                return new int[0];
            }
        }
        
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = reversePost.pop();
        }
        
        return order;
    }
    
    private ArrayList<Integer>[] makeGraph(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
    
    private boolean dfs(ArrayList<Integer>[] graph, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : graph[v]) {
            if (!marked[w] && !dfs(graph, w)) {
                return false;
            }
            if (onStack[w]) {
                return false;
            }
        }
        
        onStack[v] = false;
        reversePost.push(v);
        return true;
    }
    
    private int[] bfs(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = makeGraph(numCourses, prerequisites);
        
        int[] degrees = new int[numCourses];
        for (ArrayList<Integer> neighbors : graph) {
            for (int n : neighbors) {
                degrees[n]++;
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        int visited = 0;
        int[] order = new int[numCourses];        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            order[visited++] = v;
            for (int w : graph[v]) {
                degrees[w]--;
                if (degrees[w] == 0) {
                    queue.offer(w);
                }
            }
        }
        
        return visited == numCourses? order : new int[0];
    }    
}
