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
         if (num.length < 2) return;
         
         // search for first number not in ascending order from end
         int index = num.length - 2;
         while ( index >= 0 && num[index] >= num[index+1] ) {
             index--;
         }     
         
         reverseArray(num, index+1, num.length-1); // reverse ascending part
         if (index < 0) return; // all numbers in ascending order
         int pivotIndex = index; // first number not in ascending order
         
         // find first number greater than pivot behind pivot
         index = pivotIndex + 1;
         while (index < num.length && num[index] <= num[pivotIndex]) {
             index++;
         }      

         // swap pivot with next greater number behind the pivot
         exch(num, pivotIndex, index);
     }

    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverseArray(int[] a, int start, int end) {
        if (start > end || start < 0 || end >= a.length) return;
        while (start < end) {
            exch(a, start, end);
            start++;
            end--;
        }
    }
}
