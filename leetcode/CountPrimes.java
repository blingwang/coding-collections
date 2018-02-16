class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        
        boolean[] isComposite = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    isComposite[i * j] = true;
                }
            }
        }
        
        return count;
    }
}
