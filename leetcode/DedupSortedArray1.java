public class DedupSortedArray1 {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int updateIndex = 1;
        int pre = A[0];
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] != pre) {
               A[updateIndex++] = A[i];
               pre = A[i];
            }
        }
        return updateIndex;
    }
}
