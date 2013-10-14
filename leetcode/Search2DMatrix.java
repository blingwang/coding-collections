class Search2DMatrix {
    /**** if current row is always less than next row, matrix is sorted array ***/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public boolean findElementStepWise(int[][] matrix, int elem) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        if (elem < matrix[0][0] || elem > matrix[numRows-1][numCols-1]) {
            return false;
        }

        int row = 0;
        int col = numCols - 1;
        while (row < numRows && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public boolean searchPartialSortedMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        return findElementBinPart(matrix, target, 0, 0, numRows-1, numCols-1);
    }

    private boolean findElementBinPart(int[][] matrix, int target, int u, int l, int d, int r) {
        if (u > d || l > r) return false;
        if (target < matrix[u][l] || target > matrix[d][r]) return false;
        
        // find first element greater than target in middle row
        int midRow = u + (d-u)/2;
        int col = findFirstEqualOrGreater(matrix[midRow], target, l, r);
        
        if (col < 0) { // no element equal or greater than target is found
           return findElementBinPart(matrix, target, midRow+1, l, d, r);
        }
        
        if (matrix[midRow][col] == target) {
            return true;
        }
        
        return findElementBinPart(matrix, target, u, col, midRow-1, r) ||
               findElementBinPart(matrix, target, midRow+1, l, d, col-1);
    }
    
    private int findFirstEqualOrGreater(int[] a, int target, int left, int right) {
        int bestSoFar = -1;
        while (left <= right) {
            int mid = left + (right - left);
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                bestSoFar = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return bestSoFar;
    }
}
