class CoinChange {
    private static final int[] coins = {25,10,5,1};
    public int coinChangeWays(int n) {
        return coinChangeWays(n, 0);
    }

    private int coinChangeWays(int n, int index) {
        if (n == 0) return 1;
        if (index == coins.length) return 0; 
        
        int count = 0;
        int faceValue = coins[index];
        for (int i = 0; i <= n/faceValue; i++) {
            count += coinChangeWays(n-i*faceValue, index+1);
        }
        
        return count;
    }

    // this only works for the so-called canonical coin systems, like the one used in US and many other countries
    public int[] makeChangeMinCountGreedy(int n) {// for {25,10,5,1}
        int[] changes = new int[coins.length];
        for(int i = 0; i < coins.length; i++) {
            if (n < 1) break;
            if (n >= coins[i]) { 
                changes[i] = n / coins[i];
                n %= coins[i];
            }
        }
        return changes;
    }

    public int makeChangeMinCount(int n, int[] values) { // for n values
        int[] minCounts = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < values.length; j++) {
                if (i >= values[j] && minCounts[i-values[j]] < count) {
                    count = minCounts[i-values[j]];
                }
            }
            if (count < Integer.MAX_VALUE) {
                minCounts[i] = count + 1;
            } else {
                minCounts[i] = Integer.MAX_VALUE;
            }
        }
        return minCounts[n];
    }
    
    // DP
    public int count( int S[], int m, int n )
    {
        int i, j, x, y;
     
        // We need n+1 rows as the table is consturcted in bottom up manner using 
        // the base case 0 value case (n = 0)
        int table[n+1][m];
        
        // Fill the enteries for 0 value case (n = 0)
        for (i=0; i<m; i++) 
        {
            table[0][i] = 1;
        }
     
        // Fill rest of the table enteries in bottom up manner  
        for (i = 1; i < n+1; i++)
        {
            for (j = 0; j < m; j++)
            {
                // Count of solutions including S[j]
                x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;
     
                // Count of solutions excluding S[j]
                y = (j >= 1)? table[i][j-1]: 0;
     
                // total count
                table[i][j] = x + y;
            }
        }
        return table[n][m-1];
    }
}
