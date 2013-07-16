public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int[] range = {-1, -1};
        range[0] = searchLowerBound(A, target);
        range[1] = searchUpperBound(A, target);
        return range;
    }

    private int searchLowerBound(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        int bestSoFar = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) {
                bestSoFar = mid;
                hi = mid - 1;
            } else if (a[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return bestSoFar;
    }

    private int searchUpperBound(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        int bestSoFar = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (a[mid] == target) {
                bestSoFar = mid;
                lo = mid + 1;
            } else if (a[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return bestSoFar;
    }
}
