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
}
