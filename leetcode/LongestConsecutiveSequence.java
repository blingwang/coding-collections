import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        int maxLength = 0;
        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int curNum : num) {
            numSet.add(curNum);
        }
        
        for (int curNum : num) {
            maxLength = Math.max(maxLength, getLength(numSet, curNum));
        }
        
        return maxLength;
    }
    
    private int getLength(Set<Integer> numSet, int number) {
        int length = 0;
        
        int curNum = number;
        while (numSet.contains(curNum)) {
            numSet.remove(curNum); // similar to marked in DFS
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
