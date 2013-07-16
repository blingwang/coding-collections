public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        
        for( int i = 0; i < n; i++) {
            if (A[i] <= 0 || A[i] > n) continue;
            
            while (A[i] != i + 1 && A[i] > 0 && 
                   A[i] <= n && A[i] != A[A[i]-1]) {
                int temp = A[i];
                A[i] = A[A[i]-1];
                A[temp-1] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        
        return n + 1;
    }
}
