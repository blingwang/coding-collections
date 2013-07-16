import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        int maxLength = 0;
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            numSet.add(num[i]);
        }
        
        for (int curNum : num) {
            maxLength = Math.max(maxLength, getLength(curNum, numSet));
        }
        return maxLength;
    }

    private int getLength(int number, Set<Integer> numSet) {
        int length = 0;
        int curNum = number;  
        while (numSet.contains(curNum)) {
            numSet.remove(curNum);
            length++;
            curNum--;
        }
        curNum = number + 1;
        while (numSet.contains(curNum)) {
            numSet.remove(curNum);
            length++;
            curNum++;
        }
        
        return length;
    }
}
