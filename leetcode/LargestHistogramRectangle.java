public class LargestHistogramRectangle {
    public int largestRectangleArea(int[] height) {
        int area = 0;
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<Integer>();
        int i = 0;
        while (true) {
            if ((i < height.length) && (stack.isEmpty() || height[stack.peek()] <= height[i])) {
                stack.push(i++);
            } else {
                if (stack.isEmpty()) break;
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[top] * width);
            }
        }
        
        return area;
    }

    public int largestRectangleAreaReadable(int[] height) {
        int maxArea = 0;
        // a stack of unused heights in non-descending order
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                // for each height on top of stack, 
                // left bound is stack.peek(), right bound is i
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

    public int largestRectangleAreaSlow(int[] height) {
        int area = 0;
        
        for (int i = 0; i < height.length; i++) {
            while (i+1 < height.length && height[i] <= height[i+1]) i++;
            int right = i;
            int lowest = height[right];
            for (int left = right; left >= 0; left--) {
                if (height[left] < lowest) lowest = height[left];
                int curArea = lowest * (right - left + 1);
                if (curArea > area) area = curArea;
            }        
        }
        
        return area;
    }
}
