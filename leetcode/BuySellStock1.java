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
}
