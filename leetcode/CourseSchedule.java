public class Solution {
    private boolean marked[];
    private boolean onStack[];
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!marked[i] && !dfs(graph, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs( ArrayList<Integer>[] graph, int course) {
        marked[course] = true;
        onStack[course] = true;
        
        for (int c : graph[course]) {
            if (!marked[c] && !dfs(graph, c)) return false;
            if (onStack[c]) return false;
        }
        
        onStack[course] = false;
        return true;
    }
}
