public class NextPermutation {
    /* 3 cases: 
     * 1). num.length == 1
     * 2). num is ascending ordered from end, i.e., max permutation, 
     *     next permutation is min permutation
     * 3). num is not ascending ordered from end, 
     *     swap first non-ascending ordered number with next greater number, 
     *     and reverse the ascending part behind it
     */
    public void nextPermutation(int[] num) {
        int nonAscendingStart = findNonAscendingTail(num);
        reverse(num, nonAscendingStart, num.length - 1);
        
        if (nonAscendingStart > 0) {
            int firstDescendingFromEnd = nonAscendingStart - 1;
            int nextGreater = findNextGreaterBehind(num, firstDescendingFromEnd);
            swap(num, firstDescendingFromEnd, nextGreater);
        }
    }
    
    private int findNonAscendingTail(int[] num) {
        int cur = num.length - 1;
        while (cur > 0 && num[cur-1] >= num[cur]) cur--;
        return cur;
    }
    
    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            swap(a, start++, end--);
        }
    }
    
    private int findNextGreaterBehind(int[] num, int cur) {
        int next = cur + 1;
        while (next < num.length && num[next] <= num[cur]) next++;
        return next;
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
