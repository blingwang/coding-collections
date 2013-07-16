class ReverseWords {
    public static void reverseWords(char[] words) {
        if (words.length <= 1) {
            return;
        }

        // reverse string
        reverseStr(words, 0, words.length - 1);

        // reverse each word back
        int i = 0;
        int wordStart = 0;
        int wordEnd = 0;
        while (i < words.length) {
            // find next word character
            while (i < words.length && words[i] == ' ') {
                i++;
            }

            wordStart = i; // found start of word
            
            // find next space char
            while (i < words.length && words[i] != ' ') {
                i++;
            }

            wordEnd = i - 1; // found end of word

            // reverse word 
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
