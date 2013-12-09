public class SecondLargest {
    /* This is O(N) in one pass. If you want to accept ties, 
     * then change to if (num >= high1), but as it is, 
     * it will return Integer.MIN_VALUE if there aren't 
     * at least 2 elements in the array. It will also return 
     * Integer.MIN_VALUE if the array contains only 
     * the same number if using (num >= high1).*/
    public static int secondHighest(int... nums) {
        int high1 = Integer.MIN_VALUE;
        int high2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > high1) {
                high2 = high1;
                high1 = num;
            } else if (num > high2) {
                high2 = num;
            }
        }
        return high2;
     }
}
