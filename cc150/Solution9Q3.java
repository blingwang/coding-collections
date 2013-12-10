class Solution9Q3 {
    public int findMagicIndex(int[] a) {
        int lo = 0; 
        int hi = a.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == mid) return mid;
            else if (a[mid] < mid) lo = mid+1;
            else hi = mid-1;
        }
        
        return -1;
    }
    
    public int findMagicIndexDup(int[] a) {
        return findMagicIndexDup2(a, 0, a.length - 1);
    }
    
    private int findMagicIndexDup(int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == mid) {
            return mid;
        } else if (a[mid] < mid) {
            int result = findMagicIndexDup(a, lo, a[mid]);
            if (result >= 0) return result;
            return findMagicIndexDup(a, mid + 1, hi);
        } else {
            int result = findMagicIndexDup(a, a[mid], hi);
            if (result >= 0) return result;
            return findMagicIndexDup(a, lo, mid - 1);
        }
    }
    
    private int findMagicIndexDup2(int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == mid) {
            return mid;
        } 
        
        // search left
        int result = findMagicIndexDup(a, lo, Math.min(mid-1, a[mid]));
        if (result >= 0) return result;
        
        // search right
        result = findMagicIndexDup(a, Math.max(mid+1, a[mid]), hi);
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {-2, -1, 2, 2, 5, 6};
        
        System.out.println(sol.findMagicIndexDup(a));
    }
}
