import java.util.*;
public class ClimbStairs {
    /* Solution 1 using recursion with memorization */
    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return climbStairs(n, cache);
    }

    private int climbStairs(int n, Map<Integer, Integer> cache) {
        // we can also use base cases: 0->1, negative->0
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (cache.containsKey(n)) return cache.get(n);
        int numWays = climbStairs(n-1, cache) + climbStairs(n-2, cache);
        cache.put(n, numWays);
        return numWays;
    }
    
    // Solution 2 using DP: same as fibonacci numbers
    public int climbStairsDP(int n) {
        int numWays1 = 1;
        int numWays2 = 0;
        for (int i = 0; i < n; i++) {
            numWays1 += numWays2;
            numWays2 = numWays1 - numWays2;
        }
        
        return numWays1;
    }
}
