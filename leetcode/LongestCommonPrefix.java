public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                   return strs[0].substring(0, i); 
                }
            }
        }
        return strs[0];
    }
    
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        Arrays.sort(strs); // sort too slow for large test cases
        int n = strs.length;
        int i;
        for (i = 0; i < strs[0].length() && i < strs[n-1].length(); i++) {
            if (strs[0].charAt(i) != strs[n-1].charAt(i)) break;
        }
        return strs[0].substring(0, i);
    }
}
