import java.util.*;
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] minPathSums = new int[n];
        minPathSums[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> row = triangle.get(i);
            assert(row.size() == i+1);
            minPathSums[i] = minPathSums[i-1] + row.get(i);
            
            for (int j = i-1; j > 0; j--) {
                minPathSums[j] = Math.min(minPathSums[j-1], minPathSums[j]) + row.get(j);
            }
            
            minPathSums[0] += row.get(0);
        }
        
        return min(minPathSums);
    }
    
    public int minimumTotalBottomUp(ArrayList<ArrayList<Integer>> triangle) {
        int[] pathSum = new int[triangle.size()+1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                pathSum[j] = triangle.get(i).get(j) + Math.min(pathSum[j], pathSum[j+1]);
            }
        }
        return pathSum[0];
    }

    private int min(int[] a) {
        int minValue = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < minValue) minValue = a[i];
        }
        return minValue;
    }
}
