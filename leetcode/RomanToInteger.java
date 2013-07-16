import java.util.*;
public class RomanToInteger {
    private static final Map<Character, Integer> map;
    static {
       map = new HashMap<Character, Integer>(7);
       map.put('I', 1);
       map.put('V', 5);
       map.put('X', 10);
       map.put('L', 50);
       map.put('C', 100);
       map.put('D', 500);
       map.put('M', 1000);
    }
       
    public int romanToInt(String s) {
       int result = 0;
       int preValue = 1000;
       for (int i = 0; i < s.length(); i++) {
           int value = map.get(s.charAt(i));
           result += value;
           if (value > preValue) result -= preValue * 2; 
           preValue = value;
       }
       
       return result;
    }
}
