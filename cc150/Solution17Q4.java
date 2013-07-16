class Solution17Q4 {
    public static int getMax(int a, int b) {
        int c = a -  b;

        int signA = sign(a);
        int signB = sign(b);
        int signC = sign(c);

        // if a and b have different signs, then k = sign(a)
        int useSignA = signA ^ signB;
        
        // if a and b have the same sign, the k = sign(a-b)
        int useSignC = flip(signA ^ signB);

        int k = useSignA * signA + useSignC * signC;
        int q = flip(k); // opposite to k

        return a * k + b * q;
    }

    private static int flip(int bit) {
        return bit ^ 1;
    }

    private static int sign(int a) {
        return flip( (a >> 31) & 0x1);
    }
}
