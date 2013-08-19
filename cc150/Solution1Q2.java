public class Solution1Q2 {
    public String reverse(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;	
            start++;
            end--;
        }

        return new String(chars);
    }
}
