import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        
        // process columns
        int[][] heightMatrix = new int[m][n];
        for (int j = 0; j < n; j++) {
            heightMatrix[0][j] = matrix[0][j] - '0';
            for ( int i = 1; i < m; i++) {
                heightMatrix[i][j] = matrix[i][j] == '0' ? 0 : heightMatrix[i-1][j]+1; 
            }
        }
        
        // compute largest rectangle area for each row, update max rect 
        int maxRect = 0;
        for ( int i = 0; i < m; i++) {
            maxRect = Math.max(maxRect, largestRectangleArea(heightMatrix[i]));
        }
        
        return maxRect;
    }

    private int largestRectangleArea(int[] height) {
        int maxArea = 0;     
        // stack to store indice with unused height so far
        // (lower index + 1) on stack is last index with higher or equal height
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height[top] * width);
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? height.length : 
                        height.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height[top] * width);
        }
        
        return maxArea;
    }
}
