public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        assert(A.length >= 1);
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            if (curSum > maxSum) maxSum = curSum;
            if (curSum < 0) curSum = 0;
        }
        
        return maxSum;
    }
}
