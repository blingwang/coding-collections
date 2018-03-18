class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            maxProfit = Math.max(maxProfit, p - minPrice);
        }
        return maxProfit;
    }
}

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
        if (prices.length == 0) return 0;
        int[] dailyChanges = computeDailyChanges(prices);
        return maxSubArray(dailyChanges);
    }
    
    private int[] computeDailyChanges(int[] prices) {
        int[] dailyChanges = new int[prices.length-1];
        for (int i = 0; i < dailyChanges.length; i++) {
            dailyChanges[i] = prices[i+1] - prices[i];
        }
        return dailyChanges;
    }
    
    private int maxSubArray(int[] a) {
        int maxEndingHere = 0;
        int maxSoFar = 0;
        for (int i = 0; i < a.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + a[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
