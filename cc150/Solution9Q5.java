import java.util.*;
class Solution9Q5 {
    public static ArrayList<String> permute(String s) {
        ArrayList<String> result = new ArrayList<String>();
        enumerate(s.toCharArray(), 0, result);
        return result;
    }
    
    private static void enumerate(char[] a, int k, ArrayList<String> result) {
        if (k == a.length) {
            result.add(new String(a));
            return;
        }
        for (int i = k; i < a.length; i++) {
            swap(a, k, i);
            enumerate(a, k+1, result);
            swap(a, k, i);
         }
    }  
    
    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc";
        
        for (String perm : permute(s)) {
            System.out.println(perm);
        }
        
        
        System.out.println();
    }
    
    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get the first character
        String remainder = str.substring(1); // remove the 1st character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
}
