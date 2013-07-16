class Solution18Q12 {
    public int getMaxMatrix(int[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        int[][] sumMatrix = precomputeMatrix(matrix);

        for (int topRow = 0; topRow < rowCount; topRow++) {
            for (int bottomRow = topRow; bottomRow < rowCount; bottomRow++) {
                for (int leftCol = 0; leftCol < columnCount; leftCol++) {
                    for (int rightCol = leftCol; rightCol < columnCount; rightCol++) {
                        maxArea = Math.max(maxArea, computeSum(sumMatrix, topRow,
                                    bottomRow, leftCol, rightCol));
                    }
                }
            }
        }

        return maxArea;
    }

    private int[][] precomputeMatrix(int[][] matrix) {
        int[][] sumMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 && j == 0) { // first cell
                    sumMatrix[i][j] = matrix[i][j];
                } else if (j == 0) { // first column
                    sumMatrix[i][j] = sumMatrix[i-1][j] + matrix[i][j];
                } else if (i == 0) { // first row
                    sumMatrix[i][j] = sumMatrix[i][j-1] + matrix[i][j];
                } else {
                    sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - 
                                      sumMatrix[i-1][j-1] + matrix[i][j];
                }
            }
        }

        return sumMatrix;
    }

    private int computeSum(int[][] sumMatrix, int i1, int i2, int j1, int j2) {
        if (i1 == 0 && j1 == 0) {
            return sumMatrix[i2][j2];
        } else if (i1 == 0) {
            return sumMatrix[i2][j2] - sumMatrix[i2][j1-1];
        } else if (j1 == 0) {
            return sumMatrix[i2][j2] - sumMatrix[i1-1][j2];
        } else {
            return sumMatrix[i2][j2] - sumMatrix[i2][j1-1] - sumMatrix[i1-1][j2] + 
                   sumMatrix[i1-1][j1-1];
        }
    }

    public int maxSubMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int[] partialSum = new int[colCount];
        int maxSum = 0; // max sum is an empty matrix

        for (int rowStart = 0; rowStart < rowCount; rowStart++) {
            clearArray(partialSum);

            for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
                for (int i = 0; i < colCount; i++) {
                    partialSum[i] += matrix[rowEnd][i];
                }

                int tempMaxSum = maxSubArray(partialSum, colCount);

                /* If you want to track the coordinates, add code here to do that. */
                maxSum = Math.max(maxSum, tempMaxSum);
            }
        }

        return maxSum;
    }

    private int maxSubArray(int array[], int N) {
        int maxSum = 0;
        int runningSum = 0;

        for (int i = 0; i < N; i++) {
            runningSum += array[i];
            maxSum = Math.max(maxSum, runningSum);

            /* If runningSum < 0(last element greatly < 0), 
             * no point in trying to continue the series. Reset.*/
            if (runningSum < 0) {
                runningSum = 0;
            }
        }
        return maxSum;
    }
    
    private void clearArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }
}
