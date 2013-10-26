public class StringToInt {
    public int atoi(String str) {
        long result = 0;
        int i = 0;
        
        // trim leading spaces
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i == str.length()) return 0;
        
        // check sign
        int sign = 1;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        
        // convert digits
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') break;
            
            result = result * 10 + (c - '0');
            
            if (sign > 0 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (sign < 0 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }
        
        return (int)(result * sign);
    }
}
