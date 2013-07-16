public class RemoveElements {
    public int removeElement(int[] A, int elem) {
        return removeElement2(A, elem);
    }

    public int removeElement1(int[] A, int elem) {
        if (A == null) return 0;
        int updateIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                if (updateIndex != i) A[updateIndex] = A[i];
                updateIndex++;
            }
        }
        return updateIndex;
    }

    public int removeElement2(int[] A, int elem) {
        if (A == null) return 0;
        int start = 0, end = A.length - 1;
        while (true) {
            while (start < A.length && A[start] != elem) start++;
            while (end >= 0 && A[end] == elem) end--;
            if (start > end) break;
            swap(A, start, end);
        }
        return start;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
