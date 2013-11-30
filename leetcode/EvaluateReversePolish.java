public class EvaluateReversePolish {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        for (String token : tokens) {
            if (isOp(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(execOp(token, left, right));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
    private int execOp(String op, int left, int right) {
        if (op.equals("+")) return left + right;
        else if (op.equals("-")) return left -right;
        else if (op.equals("*")) return left * right;
        else if (op.equals("/")) return left / right;
        else throw new IllegalArgumentException("Invalid input.");
    }
}
