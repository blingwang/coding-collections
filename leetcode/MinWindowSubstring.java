public class MinWindowSubstring {
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0) return "";
        if (S.length() < T.length()) return "";
        
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowBegin = -1;
        int minWindowEnd = -1;
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        int numMatched = 0;
        
        for (int i = 0; i < T.length(); i++) {
            needToFind[T.charAt(i)]++;
        }
        
        // find a window, then slide window when window begin char is found again
        for (int begin = 0, end = 0; end < S.length(); end++) {
            char c = S.charAt(end);
            if (needToFind[c] == 0) continue;
            if (needToFind[c] > hasFound[c]) numMatched++;
            hasFound[c]++;
            
            // if all chars in T have been found, advance begin to minimize window size
            // for the first window, advance until first non-trivial char is found
            // if the first window has been found, advance when begin char is found more than needed
            if (numMatched == T.length()) { 
                if (minWindowBegin >= 0 && needToFind[S.charAt(begin)] == hasFound[S.charAt(begin)]) continue;
                
                while (needToFind[S.charAt(begin)] == 0 || 
                       needToFind[S.charAt(begin)] < hasFound[S.charAt(begin)]) {
                    if (needToFind[S.charAt(begin)] < hasFound[S.charAt(begin)]) {
                        hasFound[S.charAt(begin)]--;
                    }
                    begin++;
                }
                
                // update window after begin advanced
                int windowLength = end - begin + 1;
                if (windowLength < minWindowLength) {
                    minWindowLength = windowLength;
                    minWindowBegin = begin;
                    minWindowEnd = end;
                }
            }
            
        }
        
        if (numMatched == T.length()) {
            return S.substring(minWindowBegin, minWindowEnd + 1);
        }
        
        return "";
    }
}
