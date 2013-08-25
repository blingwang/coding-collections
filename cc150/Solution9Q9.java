import java.util.*;

public class Solution9Q9 { 
    private int N = 8;

    public ArrayList<int[]> solveNQueens() {
        ArrayList<int[]> solutions = new ArrayList<int[]>();
        int[] a = new int[N];
        
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        
        placeQueens(a, solutions, 0);
        return solutions;
    }
    
    private void placeQueens(int[] a, ArrayList<int[]> solutions, int k) {
        if (k == N) {
            solutions.add(Arrays.copyOf(a, a.length));
            return;
        }
        
        for (int i = k; i < N; i++) {
            swap(a, k, i);
            if (isValid(a, k)) placeQueens(a, solutions, k+1);
            swap(a, k, i);
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean isValid(int[] a, int k) {
        for (int i = 0; i < k; i++) { // row distance == col distance
            if (a[k] - a[i] == k - i || a[i] - a[k] == k - i) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int[] a : sol.solveNQueens()) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
