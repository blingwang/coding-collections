public class SearchInsertionPosition {
    public int searchInsert(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < target)        left = mid + 1;
            else if (A[mid] > target)   right = mid - 1;
            else                        return mid;
        }
        
        return left; // left is the first greater or equal position
    }
    
    public int searchInsert2(int[] A, int target) {
        int left = 0; 
        int right = A.length - 1;
        int bestSoFar = -1;
        
        // insert position should be equal or first greater
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) return mid;
            if (A[mid] < target) { 
                left = mid + 1;
            } else { 
                bestSoFar = mid;
                right = mid - 1;
            }
        }
        
        if (bestSoFar < 0) return A.length; // all less than target
        
        return bestSoFar;     
    }
}
