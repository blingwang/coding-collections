public class UniquePaths {
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
