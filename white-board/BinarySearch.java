public class BinarySearch {
    // search for first index that p is true
    private int searchLowerBound(int[] a, int target, Callable<Integer> p) {
        int lo = 0, hi = a.length - 1;
        int bestSoFar = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (p.predicate(a[mid], target)) {
                // we found a potential minimum x, 
                // but we should still check to see 
                // if any smaller ones work
                bestSoFar = mid;
                hi = mid - 1;
            } else {
                // the predicate is false, so we need to 
                // go right to find true values
                lo = mid + 1;
            }
        }
        
        return bestSoFar;
    }

    // search for last index that p is true
    private int searchUpperBound(int[] a, int target, Callable<Integer> p) {
        int lo = 0, hi = a.length - 1;
        int bestSoFar = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (p.predicate(a[mid], target)) {
                // we found a potential maximum x, 
                // but we should still check to see 
                // if any larger ones work
                bestSoFar = mid;
                lo = mid + 1;
            } else {
                // the predicate is false, so we need to 
                // go left to find true values
                hi = mid - 1;
            }
        }
        
        return bestSoFar;
    }

    public int searchClosest(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        
        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) return mid;
            if (a[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return (a[hi] - target < target - a[lo]) ? hi : lo;
        
    }

    public static void main(String[] args) {
        int[] A = {1,1,2,4,5,5,5,6,6,6,6,8,10,10,11};
        int target = 8;
        BinarySearch bs = new BinarySearch();
        int lowerBound = bs.searchLowerBound(A, target, bs.new LowerBoundPredicate());
        int upperBound = bs.searchUpperBound(A, target, bs.new UpperBoundPredicate());
        int closest = bs.searchClosest(A, target);
        
        System.out.println("target: " + target + "lower bound: " + lowerBound + " upper bound: " + upperBound + 
                                           " closest: " + closest);
    }

    private class LowerBoundPredicate implements Callable<Integer> {
        public boolean predicate(Integer value, Integer target){
                return value >= target;
        }
    }

    private class UpperBoundPredicate implements Callable<Integer> {
        public boolean predicate(Integer value, Integer target){
                return value <= target;
        }
    }

    private interface Callable<T> {
        public boolean predicate(T arg1, T arg2);
    }
}
