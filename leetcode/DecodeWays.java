import java.util.*;
public class DecodeWays {
    Map<Integer, Integer> cache;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        cache = new HashMap<Integer, Integer>();
        return countDecodings(s, 0);
    }

    public int countDecodings(String s, int beginIndex) {
        if (cache.containsKey(beginIndex)) return cache.get(beginIndex);
        if (beginIndex == s.length()) return 1;
        
        int count = 0;
        if (s.charAt(beginIndex) != '0') {
            count += countDecodings(s, beginIndex+1);
        } 
        if (isValidTwoDigits(s, beginIndex)){
            count += countDecodings(s, beginIndex+2);
        }
        
        cache.put(beginIndex, count);
        return count;
    }
    
    public int numDecodingsDP(String s) {// similar to fibonacci
        if (s.isEmpty()) return 0;
        int pre1 = 1, pre2 = 1; // we consider start as valid
        
        for (int i = 0; i < s.length(); i++) {
            int cur = 0;
            
            if (s.charAt(i) > '0') cur += pre1;
            if (isValidTwoDigits(s, i-1)) cur += pre2;
            if (cur == 0) return 0; // also solves s starting with 0

            pre2 = pre1;
            pre1 = cur;        
        }
        
        return pre1;
    }
    
    private boolean isValidTwoDigits(String s, int curIndex) {
        if (curIndex < 0 || curIndex+1 >= s.length()) return false;
        if (s.charAt(curIndex) == '1') return true;
        if (s.charAt(curIndex) == '2' && s.charAt(curIndex+1) < '7') return true;
        return false;
    }
}
