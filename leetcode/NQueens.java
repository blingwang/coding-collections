import java.util.*;
public class NQueens {
    private int N;
    private int[] a;
    ArrayList<String[]> solutions;

    public ArrayList<String[]> solveNQueens(int n) {
        N = n;
        a = new int[N];
        solutions = new ArrayList<String[]>();
        
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        
        enumerate(0);
        
        return solutions;
    }

    private void enumerate(int k) {
        if (k == N) {
            process();
            return;
        }

        for (int i = k; i < N; i++) {
            if(shouldBackTrack(k)) return;
            exch(k, i);
            enumerate(k+1);
            exch(k, i);
        }
    }

    private boolean shouldBackTrack(int k) {
        for (int i = 0; i < k; i++) {
            if (a[k] - a[i] == k - i || a[k] - a[i] == i - k) {
                return true;
            }
        }
        return false;
    }

    private void process() {
        String[] sol = new String[N];
        for (int i = 0; i < N; i++) {
            char[] row = new char[N];
            for (int j = 0; j < N; j++) {
                if (j == a[i]) {
                    row[j] = 'Q';
                } else {
                    row[j] = '.';
                } 
            }
            sol[i] = new String(row);
        }
        solutions.add(sol);
    }

    private void exch(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
