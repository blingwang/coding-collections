class Solution17Q8 {
    public static int getMaxSum(int[] a) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (maxSum < sum) {
                maxSum = sum;
            } else if (sum < 0) {//drop if negative sum
                sum = 0;
            }
        }

        return maxSum;
    }
}
