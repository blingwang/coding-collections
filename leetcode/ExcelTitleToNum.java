public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'A' + 1;
            result = result * 26 + value;
        }  
        return result;
    }
}
