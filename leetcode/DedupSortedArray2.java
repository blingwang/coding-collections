public class DedupSortedArray2 {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int updateIndex = 1;
        int preValue = A[0];
        int preCount = 1;
        
        for (int i = 1; i < A.length; i++) {
            if(A[i] != preValue) {
                A[updateIndex++] = A[i];
                preValue = A[i];
                preCount = 1;
            } else if (preCount == 1) {
                A[updateIndex++] = A[i];
                preCount++;
            }
        }
        
        return updateIndex;
    }
}
