class Solution18Q1 {
    public static int add(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        
        int sum = a ^ b; // add without carrying
        int carry = (a & b) << 1; // carry, but don't add
        return add(sum, carry); // recurse
    }
}
