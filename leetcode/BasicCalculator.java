public class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int i = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        while (i < s.length()) {
            int numValue = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                numValue = numValue * 10 + (s.charAt(i) - '0');
                i++;
            }
            
            result += sign * numValue;
            if (i == s.length()) return result;
            
            char c = s.charAt(i);
            if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result * stack.pop() + stack.pop();        
            }
            
            i++;
        }
        
        return result;
    }
}
