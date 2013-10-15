public class DedupSortedArray1 {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        
        int updateIndex = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[updateIndex-1]) {
                A[updateIndex] = A[i];
                updateIndex++;
            }
        }
        
        return updateIndex;
    }
}
