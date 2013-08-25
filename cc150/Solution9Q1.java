class Solution9Q1 {
    public static int countWays(int n) {// similar to Fib  #
        int oneStepBack = 2; // n = 2
        int twoStepBack = 1; // n = 1
        int threeStepBack = 1; // n = 0;
        
        for (int i = 3; i <= n; i++) {
            int cur = oneStepBack + twoStepBack + threeStepBack;
            threeStepBack = twoStepBack;
            twoStepBack = oneStepBack;
            oneStepBack = cur;
        }
        
        return oneStepBack;
    }

    public static int countWays2(int n) {
        int[] cache = new int[n+1];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        
        return countWaysDP(n, cache);
    }
    
    public static int countWaysDP(int n, int[] cache) {
        if (cache[n] >= 0) return cache[n];
        if (n < 0) return 0;
        if (n == 0) return 1;// all steps hopped over, got one way
        
        cache[n] = countWaysDP(n - 1, cache) + 
                   countWaysDP(n - 2, cache) + 
                   countWaysDP(n - 3, cache);
        
        return cache[n];
    }
    
    public static void main(String[] args) {
        System.out.println(countWays(3));
    }
} 
