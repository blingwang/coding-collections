import java.util.*;
public class LetterCombinationsOfPhoneNumber {
    private static final char[][] charMap = {{' '}, {}, {'a','b','c'}, {'d','e','f'}, 
                                             {'g','h','i'}, {'j','k','l'}, 
                                             {'m','n','o'},{'p','q','r','s'}, 
                                             {'t','u','v'}, {'w','x','y','z'}};
    private String digits;
    private ArrayList<String> combinations;
    
    public ArrayList<String> letterCombinations(String digits) {
        this.digits = digits;
        combinations = new ArrayList<String>();
        char[] prefix = new char[digits.length()];
        enumerate(0, prefix);
        return combinations;
    }
    
    private void enumerate(int curIndex, char[] prefix) {
        if (curIndex == digits.length()) {
            combinations.add(new String(prefix));
            return;
        }
        
        int num = digits.charAt(curIndex) - '0';
        for (char c : charMap[num]) {
            prefix[curIndex] = c;
            enumerate(curIndex + 1, prefix);
        }
    }
}
