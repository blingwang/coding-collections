public class Solution5Q3 {
    // n is positive integer, which means starting with 0
    public int getNext(int n) {
        // compute c0 and c1
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {// positive starts with 0
            c1++;
            c >>= 1;
        }

        // Error: if n == 11..1100...00, then there is no bigger number
        // with the same number of 1s
        if (c0 + c1 == 31 || n == 0) { // 01111...00000
            return -1;
        }

        int p = c0 + c1; // position of rightmost non-trailing zero

        n |= (1 << p); // flip rightmost non-trailing zero
        n &= ~((1 << p) - 1); // clear all bits to the right of p
        n |= (1 << (c1 - 1)) - 1; // Insert (c1-1) ones on the right
        return n;
    }

    public int getNextArith(int n) {
        // compute c0 and c1
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {// positive starts with 0
            c1++;
            c >>= 1;
        }

        // Error: if n == 11..1100...00, then there is no bigger number
        // with the same number of 1s
        if (c0 + c1 == 31 || n == 0) { // 01111...00000
            return -1;
        }

        return n + (1 << c0) + (1 << (c1 - 1)) - 1;
    }

    public int getPrev(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;

        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }

        if (temp == 0) {// for 00000...11111
            return -1; 
        }

        while ((temp & 1) == 0 && (temp != 0)) {
            c0++;
            temp >>= 1;
        }
        
        int p = c0 + c1;
        n &= (~0) << (p + 1); // clears from bit p onwards

        int mask = 1 << (c1 + 1) - 1; // sequence of (c1+1) ones
        n |= mask << (c0 -1);

        return n;
    }

    public int getPrevArith(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;

        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }

        if (temp == 0) {// for 00000...11111
            return -1; 
        }

        while ((temp & 1) == 0 && (temp != 0)) {
            c0++;
            temp >>= 1;
        }
        
        return n - (1 << c1) - (1 << (c0 - 1)) + 1;
    }
}
