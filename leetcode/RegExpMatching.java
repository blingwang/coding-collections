public class RegExpMatching {
    public boolean isMatch(String s, String p) {
        assert(s != null && p != null);
        return isMatch(s, 0, p, 0);     
    }

    private boolean isMatch(String s, int sStart, String p, int pStart) {
        if (pStart == p.length()) return sStart == s.length();
        if (sStart == s.length()) {
            return pStart+1 < p.length() && p.charAt(pStart+1) == '*' &&
                   isMatch(s, sStart, p, pStart + 2);
        }
        
        // match 0 or more when next char is '*'
        if (pStart + 1 != p.length() && p.charAt(pStart+1) == '*') {
            if (isMatch(s, sStart, p, pStart+2)) return true; // match none
            while (p.charAt(pStart) == '.' || s.charAt(sStart) == p.charAt(pStart)) {
                if (isMatch(s, ++sStart, p, pStart+2)) return true;
                if (sStart == s.length()) return isMatch(s, sStart, p, pStart + 2);
            }
        }
        
        return (p.charAt(pStart) == '.' || s.charAt(sStart) == p.charAt(pStart)) &&
               isMatch(s, sStart+1, p, pStart+1);
    }
}
