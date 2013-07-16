public class PalindromePartitioning2 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        boolean[][] isPalindrome = new boolean[n][n];
        
        for (int i = 0; i <= n; i++) {
            dp[i] = n - i;
        }
        
        for (int i = n; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && ( j-i < 2 || isPalindrome[i+1][j-1])) {
                    isPalindrome[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j+1] + 1);
                }
            }
        }
        
        return dp[0] - 1;
    }
}
