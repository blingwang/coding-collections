public class SecondLargest {
    public static int secondHighest(int[] nums) {
        int high1 = Integer.MIN_VALUE;
        int high2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= high1) {
                high2 = high1;
                high1 = num;
            } else if (num > high2) {
                high2 = num;
            }
        }
        return high2;
     }
}
