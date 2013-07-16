class Solution11Q1 {
    public static void merge(int[] a, int[] b, int sizeA, int sizeB) {
        assert(a.length >= sizeA + sizeB);
        int indexA = sizeA - 1;
        int indexB = sizeB - 1;
        for (int i = sizeA + sizeB - 1; i >= 0; i--) {
            if (indexA < 0) a[i] = b[indexB--];
            else if (indexB < 0) break;
            else if (a[indexA] < b[indexB]) a[i] = b[indexB--];
            else a[i] = a[indexA--];
        }
    }
}


