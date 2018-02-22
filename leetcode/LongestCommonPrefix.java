public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        
        return first;
    }
    
    // sort and compare first and last
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        Arrays.sort(strs); // sort too slow for large test cases
        
        String first = strs[0];
        String last = strs[strs.length-1];
        
        for (int i = 0; i < first.length(); i++) {
            if (i >= last.length() || first.charAt(i) != last.charAt(i)) {
                return first.substring(0, i);
            }
        }
        
        return first;
    }
}
