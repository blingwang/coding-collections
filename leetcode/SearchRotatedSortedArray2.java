public class SearchRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return true;
            if (A[mid] < A[hi]) {// right half sorted
                if (target > A[mid] && target <= A[hi]) lo = mid + 1;
                else hi = mid - 1;
            } else if (A[mid] > A[hi]) { // left half sorted
                if (target >= A[lo] && target < A[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else { // A[mid] == A[hi]
            }
        }
        
        return false;
    }
    
    public boolean search2(int[] A, int target) {
        return searchRotated(A, target, 0, A.length - 1);
    }

    public boolean searchRotated(int[] A, int target, int lo, int hi) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (A[mid] == target) return true;
        if (A[hi] < A[mid]) { // left half sorted, use hi to avoid lo=mid
            if (target >= A[lo] && target < A[mid]) {
                return searchNonRotated(A, target, lo, mid-1);
            } else {
                return searchRotated(A, target, mid+1, hi);
            } 
        } else if (A[hi] > A[mid]) { // right half sorted
                if (target > A[mid] && target <= A[hi]) {
                    return searchNonRotated(A, target, mid+1, hi);
                } else {
                    return searchRotated(A, target, lo, mid-1);
                }
        } else { // can't determine sorted half if A[lo]=A[mid] or A[hi]=A[mid]
            return searchRotated(A, target, lo, mid-1) || 
                   searchRotated(A, target, mid+1, hi);
        }
    }

    public boolean searchRotated2(int[] A, int target, int lo, int hi) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (A[mid] == target) return true;
        if (A[lo] < A[mid] || lo == mid) { // left half sorted
            if (target >= A[lo] && target < A[mid]) {
                return searchNonRotated(A, target, lo, mid-1);
            } else {
                return searchRotated(A, target, mid+1, hi);
            } 
        } else if (A[hi] > A[mid]) { // right half sorted
                if (target > A[mid] && target <= A[hi]) {
                    return searchNonRotated(A, target, mid+1, hi);
                } else {
                    return searchRotated(A, target, lo, mid-1);
                }
        } else { // can't determine sorted half if A[lo]=A[mid] or A[hi]=A[mid]
            return searchRotated(A, target, lo, mid-1) || 
                   searchRotated(A, target, mid+1, hi);
        }
    }

    private boolean searchNonRotated(int[] A, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return true;
            if (A[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
