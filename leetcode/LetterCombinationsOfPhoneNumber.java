import java.util.*;
public class LetterCombinationsOfPhoneNumber {
    private final String[] letterMap = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
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
        String letters = letterMap[num];
        for (int i = 0; i < letters.length(); i++) {
            prefix[curIndex] = letters.charAt(i);
            enumerate(curIndex + 1, prefix);
        }
    }
}
