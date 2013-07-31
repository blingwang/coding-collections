public class SearchRotatedSortedArray {
    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return mid;
            if (A[hi] > A[mid]) { // right half sorted
                if (target > A[mid] && target <= A[hi]) lo = mid + 1;
                else hi = mid - 1;
            } else { // left half sorted: use hi > mid since lo <= mid
                if (target >= A[lo] && target < A[mid]) hi = mid -1;
                else lo = mid + 1;
            }
        }
        
        return -1;
    }
    
    public int search2(int[] A, int target) {
        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return mid;
            if (A[lo] <= A[mid]) { // left half is sorted, lo=mid->sorted
                if (target >= A[lo] && target < A[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else { // right half is sorted
                if (target > A[mid] && target <= A[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
    
    /* This problem is in fact the same as finding the minimum element's index.
     * If the middle element is greater than the right most element, 
     * then the pivot must be to the right; 
     * if it is not, the pivot must be to the left.
     */
    int FindSortedArrayRotation(int A[], int N) {
    int L = 0;
    int R = N - 1;

    while (A[L] > A[R]) {
        int M = L + (R - L) / 2;
        if (A[M] > A[R])
            L = M + 1;
        else
            R = M;
    }
    return L;
}
}
