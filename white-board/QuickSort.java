class QuickSort {
    public static void sort(Comparable[] a) {
        // TODO first shuffle the array
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int p = partition(a, lo, hi);
        quickSort(a, lo, p - 1);
        quickSort(a, p + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int i = lo + 1;
        int j = hi;

        while (true) {
            // i is the index of the first element >= pivot or hi 
            while (a[i].compareTo(pivot) < 0) {
                if (i == hi) break;
                i++;
            }

            // j is index of the last element <= pivot
            while (a[j].compareTo(pivot) > 0) {
                if (i == lo) break;
                j--;
            }

            if (i >= j) break;

            Comparable temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        a[lo] = a[j];
        a[j] = pivot;
        
        return j;
    }

    public static void main(String[] args) {
        Integer[] a = {6, 5, 4, 3, 2, 1};
        sort(a);
        
        for (int i : a) {
            System.out.println(i);
        }
    }
}
