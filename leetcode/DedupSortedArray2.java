public class DedupSortedArray2 {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2) return A.length;
        
        int updateIndex = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] != A[updateIndex-2]) {
                A[updateIndex] = A[i];
                updateIndex++;
            }
        }
        
        return updateIndex;
    }
}
