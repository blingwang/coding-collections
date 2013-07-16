public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int lo = 0, hi = height.length-1;
        
        // check every height from two ends, we always compute 
        // lareget possible area with current lower height
        while (lo < hi) {
            if (height[lo] < height[hi]) {
                maxArea = Math.max(maxArea, height[lo] * (hi-lo));
                lo++;
            } else {
                maxArea = Math.max(maxArea, height[hi] * (hi-lo));
                hi--;
            }
        }
        
        return maxArea;
    }
}
