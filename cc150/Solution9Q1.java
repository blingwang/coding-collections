class Solution9Q1 {
    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) { // all steps hopped over, got one way
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1, map) + 
                     countWaysDP(n - 2, map) +
                     countWaysDP(n - 3, map);
           return map[n];
        }
    }

    public static int countWays(int n) {
        int[] map = new int[n+1];
        return countWaysDP(n, map);
    }
} 
