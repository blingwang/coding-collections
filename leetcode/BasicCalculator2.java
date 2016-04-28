public class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char preOp = '+';
        int i = 0;
        
        while (i < s.length()) {
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i++) - '0');
            }       
            
            if (preOp == '+') stack.push(num);
            else if (preOp == '-') stack.push(-num);
            else if (preOp == '*') stack.push(stack.pop() * num);
            else if (preOp == '/') stack.push(stack.pop() / num);
            
            if (i == s.length()) break;
            preOp = s.charAt(i++);
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
