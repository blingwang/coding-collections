public class Solution {
    private boolean marked[];
    private boolean onStack[];
    private ArrayDeque<Integer> reversePost;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        reversePost = new ArrayDeque<Integer>();
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }
        
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
    
    private boolean dfs(ArrayList<Integer>[] graph, int course) {
        marked[course] = true;
        onStack[course] = true;
        
        for (int c : graph[course]) {
            if (!marked[c] && !dfs(graph, c)) return false;
            if (onStack[c]) return false;
        }
        
        onStack[course] = false;
        reversePost.push(course);
        return true;
    }
}
