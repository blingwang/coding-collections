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

    // TODO: Wrong solution
    private boolean isMatchGreedy2(String s, String p) {
        // Greedy approach: match substring in p delimited by stars from 2 ends
        int m = p.length(), n = s.length();
        if (m == 0) return n == 0;
        
        // count non-star chars in p and check against s
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (p.charAt(i) != '*') count++;
        }
        if (count > n) return false;
        
        int lo = 0, hi = m - 1;
        
        while (lo < m && p.charAt(lo) != '*') lo++;
        while (hi >= 0 && p.charAt(hi) != '*') hi--;
        if (lo > hi) { // no star
            return isMatchNoStar(s, p);
        }
        
        if (!isMatchNoStar(p.substring(0, lo), s.substring(0, lo))) return false;
        if (!isMatchNoStar(p.substring(hi+1), s.substring(hi+n-m+1))) return false;
        
        if (hi - lo < 2) return true;
        
        String rest = p.substring(lo+1, hi);
        
        for (int i = lo; i < n; i++) {
            for (int j = hi+n-m; j >= 0 && i <= j; j--) {
                if (isMatchGreedy(s.substring(i, j+1), rest)) return true;
            }
            
        }
        
        return false;
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
