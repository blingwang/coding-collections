public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            char c = (char)('A' + (n-1) % 26);
            result.append(c);
            n = (n-1) / 26;
        }
        return result.reverse().toString();
    }
}
