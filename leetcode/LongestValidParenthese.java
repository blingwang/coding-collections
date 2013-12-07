import java.util.*;
public class LongestValidParenthese {
    public int longestValidParentheses(String s) {
        boolean[] unmatched = new boolean[s.length()];
        
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0){
                leftCount--;
            } else {
                unmatched[i] = true;
            }
        }
        
        int rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                rightCount++;
            } else if (rightCount > 0) {
                rightCount--;
            } else {
                unmatched[i] = true;
            }
        }
        
        int maxLength = 0;
        int curLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (unmatched[i]) {
                curLength = 0;
            } else {
                curLength++;
            }
            
            maxLength = Math.max(maxLength, curLength);
        }
        
        return maxLength;
    }
    
    public int longestValidParentheses2(String s) { // no extra space
        return Math.max(findValidParentheses(s, 0, s.length(), 1, '('), 
                        findValidParentheses(s, s.length()-1, -1, -1, ')'));
    }
    
    private int findValidParentheses(String s, int start, int end, int step, char cc) {
        int maxLength = 0;
        int curLength = 0;
        int count = 0;
        
        for (int i = start; i != end; i += step) {
            if (s.charAt(i) == cc) {
                count++;
            } else if (count > 0) {
                count--;
                curLength += 2;
                
                if (count == 0) { // valid substring
                    maxLength = Math.max(maxLength, curLength);
                }
            } else {
                curLength = 0;
            }
        }
        
        return maxLength;
    }

    public int longestValidParentheses3(String s) {
        int maxLength = 0;
        int lastInvalidRight = -1;
        ArrayDeque<Integer> leftsStack = new ArrayDeque<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftsStack.push(i);
            } else if (leftsStack.isEmpty()) {// no match
                    lastInvalidRight = i;
            } else {
                leftsStack.pop();
                int curLength = 0;
                
                if (leftsStack.isEmpty()) {// to last invalid right
                    curLength = i - lastInvalidRight; 
                } else { // to last unmatched left
                    curLength = i - leftsStack.peek();
                }
                
                maxLength = Math.max(maxLength, curLength);
            }
        }
        
        return maxLength;
    }
}
