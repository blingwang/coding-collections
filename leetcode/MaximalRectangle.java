import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        
        // create height matrix
        int[][] heights = new int[m][n];
        for (int j = 0; j < n; j++) {
            heights[0][j] = matrix[0][j] - '0';
            for (int i = 1; i < m; i++) {
                heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i-1][j] + 1;
            }
        }
        
        // compute largest reactangle in histogram
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(heights[i]));
        }
        
        return maxArea;
    }
    
    private int largestRectangleArea(int[] height) {
        int maxArea = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height[top] * width;
                maxArea = Math.max(maxArea, area);
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? height.length : 
                        height.length - stack.peek() - 1;
            int area = height[top] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
