class Solution11Q6 {
    public static boolean findElementStepWise(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        
        int row = 0;
        int col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target)  col--;
            else                            row++;
        }
        
        return false;
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        
        return findElementBinPart(matrix, target, 0, 0, m-1, n-1);
    }
    
    private static boolean findElementBinPart(int[][] matrix, int target, 
                                             int u, int l, int d, int r) {
        if (u > d || l > r) return false;
        if (target < matrix[u][l] || target > matrix[d][r]) return false;
        
        int midRow = u + (d - u) / 2; // mid row;
        int col = findFirstNoLessThan(matrix[midRow], l, r, target);
        
        if (col < 0) {
            return findElementBinPart(matrix, target, midRow + 1, l, d, r);
        }
        
        if (matrix[midRow][col] == target) return true;
        
        return findElementBinPart(matrix, target, u, col, midRow - 1, r) || 
               findElementBinPart(matrix, target, midRow + 1, l, d, col - 1);
    }
    
    private static int findFirstNoLessThan(int[] a, int lo, int hi, int target) {
        int bestSoFar = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) return mid;
            if (a[mid] > target) {
                bestSoFar = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return bestSoFar;
    }

    private static int findFirstNoLessThan2(int[] a, int value, int start, int end) {
        if (start > end) return -1;

        int left = start;
        int right = end;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (value == a[mid]) return mid;
            if (value < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Now only one element left: left==right
        if (value <= a[left]) return left;
        return left+1 > end ? -1 : left+1;
    }   

    private static int findFirstNoLessThanR(int[] a, int value, int start, int end) {
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if (value == a[mid]) return mid;
        if (value > a[mid]) return findFirstNoLessThanR(a, value, mid+1, end);
        int found = findFirstNoLessThanR(a, value, start, mid-1);
        if(found < 0) return mid;
        return found;
    }
}
