public class StringToInt {
    public int atoi(String str) {
        if (str.length() == 0) return 0;
        
        long result = 0;
        int i = 0;
        
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i == str.length()) return 0;
        
        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') break;
            result = result * 10 + (c - '0');;
            if (result > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        
        return (int)result * sign;
    }
}
