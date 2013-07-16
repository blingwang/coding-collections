class Solution11Q6 {
    public static boolean findElementStepWise(int[][] matrix, int elem) {
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

    private static boolean findElementBinPart(int[][] matrix, int target, int u, int l, int d, int r) {
        if (u > d || l > r) return false;
        if (target < matrix[u][l] || target > matrix[d][r]) return false;

        // find first element greater than target in middle row
        int mid = u + (d - u) / 2;
        int col = findFirstNoLessThan(matrix[mid], target, l, r);

        if (col < 0) { // no element equal or greater than target is found
            return findElementBinPart(matrix, target, mid+1, l, d, r);
        }

        if (target == matrix[mid][col]) return true;

        return findElementBinPart(matrix, target, mid+1, l, d, col-1) || 
               findElementBinPart(matrix, target, u, col, mid-1, r);
    }

    public static boolean findElementBinPart(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        return findElementBinPart(matrix, target, 0, 0, numRows-1, numCols-1);
    }

    private static int findFirstNoLessThan(int[] a, int value, int start, int end) {
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
