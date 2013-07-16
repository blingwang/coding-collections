public class Solution1Q3{
    // assume comparsion is case sensitive and whitespace is significant

    // solution 1 using sorted string
    public String sort(String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        return sort(s).equals(sort(t));
    }

    // solution 2
    public boolean isAnagram2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] letters = new int[256];// assumption
        
        char[] sArray = s.toCharArray();
        for(char c : sArray){// count number of each char in s
            letters[c]++;
        }

        // no need to put t in a char array
        for(int i = 0; i < t.length(); i++){
            int c = (int) t.charAt(i);

            // only need to test if count of c is 0 to 
            // compare two strings with equal length
            // at least one extra char in t, not in s
            if(--letters[c] < 0){
                return false;
            }
        }

        return true;
    }
}

