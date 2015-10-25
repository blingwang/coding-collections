public class Solution {
    public String reverseWords(String s) {
        char[] chars = toTrimmedCharArray(s);
        reverseCharArray(chars, 0, chars.length - 1);

        if (chars.length == 0) return "";

        int i = 0;
        while (true) {
            while (i < chars.length && chars[i] == ' ') i++;
            if (i == chars.length) break;
            int wordStart = i;

            while (i < chars.length && chars[i] != ' ') i++;
            int wordEnd = i - 1;

            reverseCharArray(chars, wordStart, wordEnd);
        }

        return new String(chars);
    }

    private char[] toTrimmedCharArray(String s) {
        s = s.trim();
        ArrayList<Character> charList = new ArrayList<Character>();

        boolean preIsSpace = false;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if (curChar == ' ') {
                if (preIsSpace) continue;
                preIsSpace = true;
            } else {
                preIsSpace = false;
            }

            charList.add(curChar);
        }

        char[] chars = new char[charList.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = charList.get(i);
        }

        return chars;
    }

    private void reverseCharArray(char[] chars, int start, int end) {
        if (start < 0 || end >= chars.length) return;

        while (start < end) {
            char startChar = chars[start];
            chars[start] = chars[end];
            chars[end] = startChar;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords(" a"));
    }
}
