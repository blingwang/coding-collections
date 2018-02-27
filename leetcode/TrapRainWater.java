public class TrapRainWater {
    public int trapWithTwoPointers(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        
        return sum;
    }
    
    public int trap(int[] A) {
        if (A.length == 0) return 0;
        int n = A.length;
        
        int[] preMax = new int[n];
        preMax[0] = A[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i-1], A[i]);
        }
        
        int[] postMax = new int[n];
        postMax[n-1] = A[n-1];
        for (int i = n - 2; i >= 0; i--) {
            postMax[i] = Math.max(postMax[i+1], A[i]);
        }
        
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(preMax[i], postMax[i]) - A[i];
        }
        
        return totalWater;
    }
}
