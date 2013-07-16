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

    public int longestValidParentheses2(String s) {
        int maxCount = 0;
        int last = -1;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i; // no match
                } else {
                    stack.pop(); 
                    if (stack.isEmpty()) { // match to last unmatched right
                        maxCount = Math.max(maxCount, i-last);
                    } else { // match to last unmatched left
                        maxCount = Math.max(maxCount, i-stack.peek());
                    }
                }
            }
        }

        return maxCount;
    }
}
