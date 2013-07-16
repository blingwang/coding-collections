public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        
        while (i >= 0) {
            if (s.charAt(i) != ' ') break;
            i--;
        }
        
        while (i >= 0) {
            if (s.charAt(i) == ' ') break;
            count++;
            i--;
        }
        
        return count;
    }
}
