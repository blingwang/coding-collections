public class SortColors {
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
