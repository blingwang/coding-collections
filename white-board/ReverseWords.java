class ReverseWords {
    public static void reverseWords(char[] words) {
        if (words.length <= 1) return;
        
        reverseStr(words, 0, words.length - 1);

        int i = 0;
        while (true) {
            while (i < words.length && words[i] == ' ') i++;
            if (i == words.length) break; // no words left
            int wordStart = i; 
            
            while (i < words.length && words[i] != ' ') i++;
            int wordEnd = i - 1; 

            reverseStr(words, wordStart, wordEnd);
        }
    }

    private static void reverseStr(char[] str, int start, int end) {
        if (start < 0 || end >= str.length || start > end) return;
        
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String test = "hello world";
        char[] testArray = test.toCharArray();
        reverseWords(testArray);
        System.out.println(new String(testArray));
    }
}
