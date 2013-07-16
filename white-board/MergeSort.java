class MergeSort {
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    private static void mergeSort(Comparable[] a, Comparable[] aux,
                                  int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sortBU(Comparable[] a) {
        int len = a.length;
        Comparable[] aux = new Comparable[len];

        for (int sz = 1; sz < len; sz = sz + sz) {
            for(int lo = 0; lo < len - sz; lo += sz + sz) {
                int mid = lo + sz - 1;
                int hi = Math.min(lo + sz + sz - 1, len - 1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux,
                              int lo, int mid, int hi) {
        // copy array in range
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        // merge two sorted array
        int i = lo; 
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) > 0) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5, 3, 1, 8, 2, 9, 7};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
