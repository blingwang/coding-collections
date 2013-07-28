public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        return isMatchGreedy(s, p);
    }

    private boolean isMatchDP(String s, String p) {
        int m = p.length();
        int n = s.length();
        
        // count non-star chars in p and check against s
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (p.charAt(i) != '*') count++;
        }
        if (count > n) return false;
        
        // a row stores all indices in s that previous p matches
        boolean[][] isMatched = new boolean[2][n+1];
        isMatched[0][0] = true;
        
        for (int i = 0; i < m; i++) {
            int cur = (i+1) % 2;
            int pre = i % 2;
            java.util.Arrays.fill(isMatched[cur], false);
            
            char c = p.charAt(i);
            if (c == '*') {
                for (int j = 0; j <= n; j++) {
                    if (isMatched[pre][j]) {
                        while (j <= n) isMatched[cur][j++] = true;
                    }
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (isMatched[pre][j] && (c == '?' || c == s.charAt(j))) {
                        isMatched[cur][j+1] = true;
                    }
                }
            }
        }
        
        return isMatched[m%2][n];
    }
    
    public boolean isMatchDP2(String s, String p) {
        int m = p.length();
        int n = s.length();
        
        // count non-star chars in p and check against s
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (p.charAt(i) != '*') count++;
        }
        if (count > n) return false;//n>=count=>enough chars in s
        
        boolean[] matched = new boolean[n+1];
        matched[0] = true;
        for (int i = 0; i < m; i++) {
            char c = p.charAt(i);
            if (c == '*') {
                for (int j = 0; j <= n; j++) {
                    if (matched[j]) {
                        while (j <= n) matched[j++] = true;
                        break;
                    }
                }
            } else {
                for (int j = n-1; j >= 0; j--) {
                    if (matched[j] && (c == s.charAt(j) || c == '?')) matched[j+1] = true;
                    else matched[j+1] = false;
                }
                matched[0] = false;
            }
        }
        
        return matched[n];
    }

    private boolean isMatchGreedy(String s, String p) {
        // Greedy approach: try to match each substring in p delimited by stars
        // We always choose the first substring match in s
        int starPos = -1;
        int matchStart = 0;
        int i = 0; // char index in s
        int j = 0; // char index in p
        while (i < s.length()) {
            while (j < p.length() && p.charAt(j) == '*') {
                starPos = j++;
                matchStart = i;
            } 
            
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else {
                if (starPos < 0) return false;
                i = ++matchStart;
                j = starPos + 1;
            }
        }
        
        while (j < p.length() && p.charAt(j) == '*') j++;
        
        return j == p.length();
    }

    public boolean isMatchGreedy2(String s, String p) {
        int m = p.length();
        int n = s.length();
        
        // count non-star chars in p and check against s
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (p.charAt(i) != '*') count++;
        }
        if (count > n) return false;//n>=count=>enough chars in s
        
        // find exact match from two ends until star is found
        int start = 0;
        while (start < m && p.charAt(start) != '*') {
            char cp = p.charAt(start);
            char cs = s.charAt(start);
            if (cs != cp && cp != '?') return false;
            start++;
        }
        if (start == m) return start == n; // no star found
        
        int pEnd = m-1, sEnd = n-1;
        while (pEnd >= 0 && p.charAt(pEnd) != '*') {
            char cp = p.charAt(pEnd);
            char cs = s.charAt(sEnd);
            if (cs != cp && cp != '?') return false;
            pEnd--;
            sEnd--;
        }
        
        // for the rest, match substrings of p
        s = s.substring(start, sEnd+1);
        p = p.substring(start, pEnd+1);
        
        String[] substrs = p.split("\\*+");
        for (String str : substrs) {
            if (str.length() == 0) continue; // ignore empty substring
            int match = strStr(s, str);
            if( match < 0) return false;
            s = s.substring(match + str.length());
        }
        
        return true;
    }
    
    private int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j) && 
                    needle.charAt(j) != '?') {
                        break;
                }
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

    private boolean isMatchNoStar(String s, String p) {
        if (s.length() != p.length()) return false;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c != '?' && c != s.charAt(i)) return false;
        }
        return true;
    }

    // simple recursion, slow
    private boolean isMatch(String s, String p, int sStart, int pStart) {
        if (pStart == p.length()) return sStart == s.length();
        
        char c = p.charAt(pStart);    
        if (c == '*') {
            for (int i = 0; i <= s.length()-sStart; i++) {
                if (isMatch(s, p, sStart+i, pStart+1)) return true;
            }
        }
        
        if (sStart < s.length() && (c == '?' || c == s.charAt(sStart))) {
            return isMatch(s, p, sStart+1, pStart+1);
        }
        
        return false;
    }
}
