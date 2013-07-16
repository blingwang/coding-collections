public class Solution5Q5 {
    public static int bitSwapRequired(int a, int b) {
        int count = 0;

        for (int c = a ^ b; c != 0; c = c & (c-1)) {
            count++;
        }

        return count;
    }
}
