public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int maxProfit = 0;
        int[] profitBefore = new int[n];
        int[] profitAfter = new int[n];
        
        int lowest = prices[0];
        for (int i = 1; i < n; i++) {
            lowest = Math.min(lowest, prices[i]);
            profitBefore[i] = Math.max(profitBefore[i-1], prices[i] - lowest);
        }
        
        int largest = prices[n-1];
        for (int i = n-2; i >= 0; i--) {
            largest = Math.max(largest, prices[i]);
            profitAfter[i] = Math.max(profitAfter[i+1], largest - prices[i]);
        }
        
        for (int i = 0; i < n - 1; i++) {
            maxProfit = Math.max(maxProfit, profitBefore[i] + profitAfter[i+1]);
        }
        
        maxProfit = Math.max(maxProfit, profitBefore[n-1]);
        
        return maxProfit;
    }
}
