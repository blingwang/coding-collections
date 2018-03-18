public class MaximumSubarray {
    // modified Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0]; 
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
    public int maxSubArrayRecursive(int[] A) {// divide and conquer
        return maxSubArray(A, 0, A.length-1);
    }
    
    private int maxSubArray(int[] A, int lo, int hi) {
        if (lo == hi) return A[lo];
        int mid = lo + (hi - lo) / 2;
        return max(maxSubArray(A, lo, mid), 
                   maxSubArray(A, mid+1, hi), 
                   maxCrossingSum(A, lo, hi));
    }
    
    private int maxCrossingSum(int[] A, int lo, int hi) {
        assert(hi - lo > 0);
        int sum = 0;
        int mid = lo + (hi - lo) / 2;
        
        // expand to low half
        int loSum = Integer.MIN_VALUE;
        for (int i = mid; i >= lo; i--) {
            sum += A[i];
            loSum = Math.max(loSum, sum);
        } 
        
        // expand to high half
        sum = 0;
        int hiSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= hi; i++) {
            sum += A[i];
            hiSum = Math.max(hiSum, sum);
        } 
        
        return loSum + hiSum;
    }
    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }
}
