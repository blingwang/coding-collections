class NQueens2 {
    // leetcode instance objects are reused
    private int N;
    private int[] a;
    private int count = 0;

    public int totalNQueens(int n) {
        N = n;
        count = 0; // reset instance variable for leetcode
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        enumerate(0);
        return count;
    }

    private void enumerate(int k) {
        if (k == N) {
            count++;
            return;
        }

        // TODO enumerate N/2 choices for k=0

        for (int i = k; i < N; i++) {
            exch(a, k, i);
            if(!backtrack(k)) enumerate(k+1);
            exch(a, k, i);
        }
    }

    private boolean backtrack(int k) {
        for (int i = 0; i < k; i++) {
            if (a[k] - a[i] == k - i || a[k] - a[i] == i - k) {
                return true;
            }
        }
        return false;
    }

    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
