public class MedianOfTwoSortedArrays {

    private double findMedianWithMerge(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int mid1 = (m+n-1) / 2, mid2 = (m+n) / 2;
        int median1 = 0, median2 = 0;
        int i = 0, j = 0;
        
        for (int k = 0; k <= mid2; k++) {
            int kth = 0;
            if (i == m)             kth = B[j++];
            else if (j == n)        kth = A[i++];
            else if (A[i] > B[j])   kth = B[j++];
            else                    kth = A[i++];
            
            if (k == mid1) median1 = kth;
            if (k == mid2) median2 = kth;
        }
        
        return (median1 + median2) / 2.0;
    }
    
    public double findMedianSortedArraysSublinear(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int total = m + n;
        if ((total & 0x1) == 1) return findKth(A, 0, m, B, 0, n, total/2 + 1);
        else return (findKth(A, 0, m, B, 0, n, total/2) + 
                     findKth(A, 0, m, B, 0, n, (total/2)+1)) / 2;
    }
    
    private double findKth(int a[], int sa, int m, int b[], int sb, int n, int k) {
        if (m > n) return findKth(b, sb, n, a, sa, m, k);
    
        if (m == 0) return b[sb+k-1];
        if (k == 1) return Math.min(a[sa], b[sb]);
        
        // drop elements smaller than kth in a and b: compare k/2 th 
        int pa = Math.min(k/2, m), pb = k - pa;
        if (a[sa+pa-1] < b[sb+pb-1]) return findKth(a, sa+pa, m-pa, b, sb, n, k - pa);
        return findKth(a, sa, m, b, sb+pb, n-pb, k-pb);
    }
}
