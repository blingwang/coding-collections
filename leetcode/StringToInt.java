class Solution {
    public int myAtoi(String str) {
        int i = 0;  
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i == str.length()) return 0;
        
        int sign = 1;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        
        long result = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + str.charAt(i) - '0';
            if (sign > 0 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign < 0 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        
        return (int)(result * sign);
    }
}
