public class SearchRotatedSortedArray {
    public int search(int[] A, int target) {
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
}
