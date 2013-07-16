import java.util.*;
public class LetterCombinationsOfPhoneNumber {
    private static final char[][] map = {{' '}, {}, {'a','b','c'}, {'d','e','f'},
                                         {'g','h','i'}, {'j','k','l'},
                                         {'m','n','o'}, {'p','q','r','s'}, 
                                         {'t','u','v'}, {'w','x','y','z'}};
    private ArrayList<String> list;

    public ArrayList<String> letterCombinations(String digits) {
        list = new ArrayList<String>();
        char[] prefix = new char[digits.length()];
        enumerate(digits, prefix, 0);
        return list;
    }

    private void enumerate(String digits, char[] prefix, int index) {
        if (index == digits.length()) {
            list.add(new String(prefix));
            return;
        }

        int num = digits.charAt(index) - '0';
        for (char c : map[num]) {
            prefix[index] = c;
            enumerate(digits, prefix, index+1);
        }
    }
}
