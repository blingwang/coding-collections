public class JumpGame2 {
    public int jump(int[] A) { // BFS
        int minSteps = 0;
        int curMax = 0; 
        int nextMax = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (i > curMax) { // one more degree
                if (i > nextMax) return -1;
                minSteps++;
                curMax = nextMax;
            }
            
            nextMax = Math.max(nextMax, i + A[i]);
        }
        
        return minSteps;
    }
    
    public int jump2(int[] A) {
        int numSteps = 0;
        int minToIndex = 0;
        int maxToIndex = 0;
        
        while (minToIndex <= maxToIndex) { // move range window by degree
            if (maxToIndex >= A.length - 1) return numSteps;
            int curMax = 0;
            for (int i = minToIndex; i <= maxToIndex; i++) {
                curMax = Math.max(curMax, i + A[i]);
            }
            minToIndex = maxToIndex + 1;
            maxToIndex = curMax;
            numSteps++; 
        }
        
        return -1;
    }
}
