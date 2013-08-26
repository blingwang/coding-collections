class Solution11Q3 {
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
            } else {
                hi--; // A[mid] == A[hi]: move hi
            }
        }
        
        return false;
    }
    
    public static int search2(int[] a, int left, int right, int x) {
        if (right < left) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (x == a[mid]) {
            return mid;
        }

        if (a[left] < a[mid]) { // left is ordered
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x); // search left
            } else {
                return search(a, mid + 1, right, x); // search right
            }
        } else if (a[left] > a[mid]) { // right is orderd
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x); // search right
            } else {
                return search(a, left, mid - 1, x); // search left
            }
        } else if (a[left] == a[mid]) {
            /* right < mid: pivot should be on right side
             * right > mid: array is sorted
             * right == mid: pivot can be on either side
             */
            if (a[mid] != a[right]) { // pivot on right side
                return search(a, mid + 1, right, x); // search right
            }
            // if right equal to mid, pivot position is unknown
            int result = search(a, left, mid - 1, x); // search left
            if (result == -1) {
                return search(a, mid + 1, right, x); // search right
            }
            return result;
        }

        return -1;
    }
}
