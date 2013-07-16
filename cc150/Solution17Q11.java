import java.util.*;
class Solution17Q11 {
    // this solution has nondeterministic number of calls
    public static int rand7() {
        while (true) {
            int num = 5 * rand5() + rand5();
            if (num < 21) {
                return num % 7;
            }
        }
    }

    private static int rand5() {
        Random ran = new Random();
        return ran.nextInt(5);
    }
}
