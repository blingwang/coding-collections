public class MedianOfTwoSortedArrays {
     public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        int total = m + n;
        
        if ((total & 0x1) == 1) return findKth(A, B, total/2 + 1);
        
        return (findKth(A, B, total/2) + findKth(A, B, total/2 + 1)) / 2;
    }
    
    private double findKth(int[] A, int[] B, int rank) {
        assert(rank > 0 && rank <= A.length + B.length);
        int kth = 0;
        for (int i = 0, j = 0, k = 0; k < rank; k++) {
            if (i == A.length)      kth = B[j++];
            else if (j == B.length) kth = A[i++];
            else if (A[i] > B[j])   kth = B[j++];
            else                    kth = A[i++];
        }
        return kth;
    }

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
        int total = A.length + B.length;
        
        if ((total & 0x1) == 1) {
             return findKth(A, 0, A.length, B, 0, B.length, total/2 + 1);
        }
        
        return (findKth(A, 0, A.length, B, 0, B.length, total/2) + 
                findKth(A, 0, A.length, B, 0, B.length, total/2 + 1)) / 2;
    }
    
    private double findKth(int[] A, int offA, int lenA, int[] B, int offB, int lenB, int k) {
        if (lenA > lenB) return findKth(B, offB, lenB, A, offA, lenA, k);
    
        if (lenA == 0) return B[offB+k-1];
        if (k == 1) return Math.min(A[offA], B[offB]); // base case
        
        // drop elements smaller than kth in a and b: compare k/2 th 
        int smallerAs = Math.min(k/2, lenA)
        int smallerBs = k - smallerAs;
        if (A[offA+smallerAs-1] < B[offB+smallerBs-1]) {
            return findKth(A, offA+smallerAs, lenA-smallerAs, B, offB, lenB, k-smallerAs);
        }
        
        return findKth(A, offA, lenA, B, offB+smallerBs, lenB-smallerBs, k-smallerBs);
    }
}
