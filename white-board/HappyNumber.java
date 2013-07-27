import java.util.*;
class HappyNumber {
    private static final int[] squares = {0,1,4,9,16,25,36,49,64,81};
    public static boolean isHappy(int n) {// DP possible: store computed happy #s
        Set<Integer> visited = new HashSet<Integer>();
        while (n > 1 && !visited.contains(n)) {
            visited.add(n);
            int sum = 0;
            while (n > 0) {
                sum += squares[n % 10];
                n /= 10;
            }
            n = sum;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (isHappy(i)) {
                System.out.println(i + " is happy.");
            }
        }
    }
}
