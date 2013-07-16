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
        if (startWithTwoDigitCode(s, beginIndex)){
            count += countDecodings(s, beginIndex+2);
        }
        
        cache.put(beginIndex, count);
        return count;
    }

    private boolean startWithTwoDigitCode(String s, int beginIndex) {
        if (beginIndex + 2 > s.length()) return false;
        if (s.charAt(beginIndex) == '1') return true;
        if (s.charAt(beginIndex) == '2' && s.charAt(beginIndex+1) < '7') return true;
        return false;
    }
}
