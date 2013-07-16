import java.util.*;
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] minTotals = new int[n];
        minTotals[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> row = triangle.get(i);
            assert(row.size() == i + 1);
            minTotals[i] = minTotals[i-1] + row.get(i);
            for (int j = i - 1; j >= 1; j--) {
                minTotals[j] = Math.min(minTotals[j-1], minTotals[j]) + row.get(j);
            }
            minTotals[0] += row.get(0);
        }
        
        return min(minTotals);
    }

    private int min(int[] a) {
        int minValue = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < minValue) minValue = a[i];
        }
        return minValue;
    }
}
