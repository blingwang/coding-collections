public class UniquePaths {
    // Solution 1 using recursion + memorization
    private int n;
    private Map<Integer, Integer> cache; 
    public int uniquePathsMemorization(int m, int n) {
        this.n = n;
        cache = new HashMap<Integer, Integer>();
        return uniquePathsRecur(m-1, n-1);
    }

    private int uniquePathsRecur(int x, int y) {
        if (x < 0 || y < 0) return 0;
        if (x == 0 && y == 0) return 1;
        
        int key = x * n + y;  
        if (cache.containsKey(key)) return cache.get(key);
        
        int pathCount = uniquePathsRecur(x-1, y) + uniquePathsRecur(x, y-1);
    
        cache.put(key, pathCount);
        return pathCount;
    }
    
    // Solution 2 using DP: store in matrix
    public int uniquePathsDP2(int m, int n) {
        assert(m > 0 && n > 0);
        int[][] pathCounts = new int[m+1][n+1];
        pathCounts[1][0] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pathCounts[i][j] = pathCounts[i-1][j] + pathCounts[i][j-1];
            }
        }
        
        return pathCounts[m][n];
    }
    
    // Solution 4 using combinatorics: C(m+n-2, m-1)
    public int uniquePaths(int m, int n) {
        if (m < n) return uniquePaths(n, m);
        
        long permsWithDupN = 1;
        for (int i = m; i <= m+n-2; i++) {
            permsWithDupN *= i;
        }
        int uniquePerms = (int) (permsWithDupN / factorial(n-1));
        return uniquePerms;
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
