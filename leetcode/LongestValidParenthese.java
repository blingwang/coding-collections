import java.util.*;
public class LongestValidParenthese {
    public int longestValidParentheses(String s) {
        int n = s.length();
        boolean[] unmatched = new boolean[n];
        
        int leftCount = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount++;
            } else {
                if (leftCount > 0) leftCount--;
                else unmatched[i] = true;
            }
        }
        
        int rightCount = 0;
        for (int i = n-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                rightCount++;
            } else {
                if (rightCount > 0) rightCount--;
                else unmatched[i] = true;
            }
        }
        
        int count = 0, maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (unmatched[i]) {
                maxCount = Math.max(maxCount, count);
                count = 0;
            } else {
                count++;
            }
        }
        
        maxCount = Math.max(maxCount, count);
        
        return maxCount;
    }

    public int longestValidParentheses(String s) {
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
