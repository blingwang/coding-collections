public class SortColors {
    /********use counting sort********/
    public void sortColorsByCounting(int[] A) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) zeros++;
            else if (A[i] == 1) ones++;
            else twos++;
        }
        
        for (int i = 0; i < zeros; i++) {
            A[i] = 0;
        }
        
        for (int i = zeros; i < zeros + ones; i++) {
            A[i] = 1;
        }
        
        for (int i = zeros + ones; i < zeros + ones + twos; i++) {
            A[i] = 2;
        }
    }
    
    /********use 3-way quick sort********/
    public void sortColors(int[] A) {
        int lt = 0, i = 0, gt = A.length - 1;
        while (i <= gt) {
            if (A[i] < 1) swap(A, i++, lt++);
            else if (A[i] > 1) swap(A, i, gt--);
            else i++;
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
