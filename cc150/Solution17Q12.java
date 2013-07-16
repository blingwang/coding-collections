import java.util.*;
class Solution17Q12 {
    public static void printPairSums(int[] array, int sum) {
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            int s = array[first] + array[last];
            if (s == sum) {
                System.out.println(array[first] + " " + array[last]);
                first++;
                last--;
            } else if (s < sum) {
                first++;
            } else {
                last--;
            }
        }
    }
}
