public class ValidateNumber {
    /*solution 1 using regex*/
    public boolean isNumber(String s) {
        String pattern = "^\\s*[+-]?((\\d+\\.?\\d*)|(\\d*\\.?\\d+))(e[+-]?\\d+)?\\s*$";
        return s.matches(pattern);    
    }
    
    /*solution 2 using fsm*/
    private enum Type {
        Space(0), Sign(1), Digit(2), Dot(3), Exp(4), Null(-1);
        private int type;
        private Type(int t) { type = t; }
        public int getType() { return type; }
    }
    
    public boolean isNumber2(String s) {
        int[][] states = {
            {0, 8, -1, -1, 8, -1, -1, 8, 8},  
            {2, -1, -1, -1, -1, 6, -1, -1, -1},  
            {1, 1, 1, 4, 4, 7, 7, 7, -1},  
            {3, 4, 3, -1, -1, -1, -1, -1, -1},  
            {-1, 5, -1, -1, 5, -1, -1, -1, -1}
        };
        
        int state = 0;
        for (char c : s.toCharArray()) {
            Type inputType = Type.Null;
            if (c == ' ') {
                inputType = Type.Space;
            } else if (c == '+' || c == '-') {
                inputType = Type.Sign;
            } else if (c >= '0' && c <= '9') {
                inputType = Type.Digit;
            } else if (c == '.') {
                inputType = Type.Dot;
            } else if (c == 'e' || c == 'E') {
                inputType = Type.Exp;
            } else {
                return false;
            }
            
            state = states[inputType.getType()][state];
            if (state < 0) {
                return false;
            }
        }
        
        return (state == 1 || state == 4 || state == 7 || state == 8);
    }
    
    /*solution 3*/
    public boolean isNumber3(String s) {
        s = s.trim();
        
        int i = s.indexOf('e');
        if (i < 0) {
            return isDouble(s);
        } else {
            return isDouble(s.substring(0, i)) && isInteger(s.substring(i+1));
        }
    }
    
    private boolean isDouble(String s) {
        if (startWithSign(s)) {
            return isUnsignedDouble(s.substring(1));
        } else {
            return isUnsignedDouble(s);
        }
    }
    
    private boolean isUnsignedDouble(String s) {
        int i = s.indexOf('.') ;
        if (i < 0) {
            return isUnsignedInteger(s);
        }
        
        String left = s.substring(0, i);
        String right = s.substring(i+1);
        
        if (left.isEmpty() && right.isEmpty()) return false;// "." => false
        if (!left.isEmpty() && !isUnsignedInteger(left)) return false;
        if (!right.isEmpty() && !isUnsignedInteger(right)) return false;
        
        return true;
    }
    
    private boolean isInteger(String s) {
        if (startWithSign(s)) {
            return isUnsignedInteger(s.substring(1));
        } else {
            return isUnsignedInteger(s);
        }
    }
    
    private boolean isUnsignedInteger(String s) {
        if (s.length() == 0) return false;
        
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean startWithSign(String s) {
        if (s.isEmpty()) return false;
        return s.charAt(0) == '+' || s.charAt(0) == '-';
    }
}
