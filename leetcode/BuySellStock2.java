public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0) totalProfit += diff;
        }
        
        return totalProfit;
    }

    public int maxProfitBad(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int totalProfit = 0;
        int buyPrice = prices[0];
        int sellPrice = Integer.MIN_VALUE;
        
        for (int i = 1; i < prices.length; i++) {
            if (sellPrice > buyPrice && prices[i] < sellPrice) {
                totalProfit += sellPrice - buyPrice;
                buyPrice = prices[i];            
                sellPrice = Integer.MIN_VALUE;
            } 
            else if (prices[i] <= buyPrice) buyPrice = prices[i];
            else if (prices[i] > sellPrice) sellPrice = prices[i];
               
        }
        
        if (sellPrice > buyPrice) totalProfit += sellPrice - buyPrice;
        
        return totalProfit;
    }
}
