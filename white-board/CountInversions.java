// Given array A[1...n], for every i<j, find all inversion pairs such that A[i]>A[j]
// Solution: insertion sort or merge sort
class CountInversions {
    public int count(int[] a) {
        int[] aux = new int[a.length];
        return count(a, aux, 0, a.length - 1);
    }

    private int count(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }

        int mid = lo + (hi - lo) / 2;
        return count(a, aux, lo, mid) + count(a, aux, mid + 1, hi) + 
               merge(a, aux, lo, mid, hi);
    }

    private int merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // copy array in range
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        // merge two sorted array, counting inversions
        int count = 0;
        int i = lo; 
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) > 0) {
                a[k] = aux[j++];
                count += mid - i + 1; // # of elements left in low half
            } else {
                a[k] = aux[i++];
            }
        }
        
        return count;
    }
}
