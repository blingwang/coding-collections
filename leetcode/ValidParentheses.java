import java.util.*;

public class ValidParentheses {
    private static final Map<Character, Character> map = createMap();
    
    private static Map<Character, Character> createMap() {
        Map<Character, Character> parentheses = new HashMap<Character, Character>();
        parentheses.put(')', '(');
        parentheses.put('}', '{');
        parentheses.put(']', '[');
        return Collections.unmodifiableMap(parentheses);
    }
    
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isLeft = !map.containsKey(c);
            
            if (isLeft(c)) {
                stack.push(c);
            } else {
                char left = map.get(c);
                if (stack.isEmpty() || stack.pop() != left) return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    public boolean isValid2(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default:
                    break;
                
            }
        }
        return stack.isEmpty();
    }
}
