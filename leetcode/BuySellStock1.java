public class BuySellStock1 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int minIndex = 0;
        int maxIndex = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]) {// reset if new min is found
                int profit = prices[maxIndex] - prices[minIndex];
                if (profit > maxProfit) maxProfit = profit;
                minIndex = i;
                maxIndex = i;
            } else if (prices[i] > prices[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // process last profit
        int profit = prices[maxIndex] - prices[minIndex];
        if (profit > maxProfit) maxProfit = profit;
        
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;

        int maxProfit = 0;
        int lowestSoFar = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestSoFar) {
                lowestSoFar = prices[i];
            } else {
                int profit = prices[i] - lowestSoFar;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
    
    public int maxProfitUsingMaxSubarray(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // transform input array to daily change array
        int[] dailyChanges = new int[prices.length-1];
        for (int i = 0; i < dailyChanges.length; i++) {
            dailyChanges[i] = prices[i+1] - prices[i];
        }
        
        return maxSubArray(dailyChanges);
    }
    
    private int maxSubArray(int[] A) { // Kadane's algorithm
        int maxEndingHere = 0, maxSoFar = 0;
        for (int i = 0; i < A.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + A[i]);
            maxSoFar      = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
