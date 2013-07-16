public class TrapRainWater {
    public int trap(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        
        int[] preMax = new int[n];
        int[] postMax = new int[n];
        
        preMax[0] = A[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i-1], A[i]);
        }
        
        postMax[n-1] = A[n-1];
        for (int i = n-2; i >= 0; i--) {
            postMax[i] = Math.max(postMax[i+1], A[i]);
        }
        
        int totalTrap = 0;
        for (int i = 0; i < n; i++) {
            totalTrap += Math.min(preMax[i], postMax[i]) - A[i];
        }
        
        return totalTrap;
    }
}
