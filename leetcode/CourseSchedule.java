public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // return bfsCycle(numCourses, prerequisites);
        ArrayList<Integer>[] graph = makeGraph(numCourses, prerequisites);
        boolean[] marked = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!marked[i] && !dfsCycle(graph, i, marked, onStack)) {
                return false;
            }
        }
        
        return true;
    }
    
    private ArrayList<Integer>[] makeGraph(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
        }
        return graph;
    }
    
    private boolean dfsCycle( ArrayList<Integer>[] graph, int course, boolean[] marked, boolean[] onStack) {
        marked[course] = true;
        onStack[course] = true;
        
        for (int c : graph[course]) {
            if (!marked[c] && !dfsCycle(graph, c, marked, onStack)) return false;
            if (onStack[c]) return false;
        }
        
        onStack[course] = false;
        return true;
    }
    
    public boolean bfsCycle(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = makeGraph(numCourses, prerequisites);
        int[] degrees = computeIndegree(graph);
        
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            while (j < numCourses && degrees[j] != 0) {
                j++;
            }
            if (j == numCourses) return false;
            degrees[j] = -1;
            for (int neighbor : graph[j]) {
                degrees[neighbor]--;
            }
        }
        
        return true;
    }
    
    private int[] computeIndegree(ArrayList<Integer>[] graph) {
        int[] degrees = new int[graph.length];
        for (ArrayList<Integer> neighbors : graph) {
            for (int n : neighbors) {
                degrees[n]++;
            }
        }
        return degrees;
    }
}
