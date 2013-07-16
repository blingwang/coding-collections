class Solution7Q4 {
    // flip a positive sign to negative or negative sign to positive
    public static int negate(int a) {
        int neg = 0;
        int d = a < 0 ? 1 : -1;

        while (a != 0) {
            neg += d;
            a += d;
        }

        return neg;
    }

    // multiply a by b by adding a to itself b times
    public static int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a); // algorithm is faster if b < a
        }

        int sum = 0;
        for (int i = abs(b); i > 0; i--) {
            sum += a;
        }

        if (b < 0) {
            sum = negate (sum);
        }

        return sum;
    }

    // return absolute value
    public static int abs(int a) {
        if (a < 0) {
            return negate(a);
        } else {
            return a;
        }
    }

    // division
    public int divide(int a, int b) throws java.lang.ArithmeticException {
        if (b == 0) {
            throw new java.lang.ArithmeticException("ERROR");
        }

        int absa = abs(a);
        int absb = abs(b);

        int product = 0;
        int x = 0;
        while (product + absb < absa) {
            product += absb;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
           return x;
        } else {
           return negate(x);
        }
    }
} 
