import java.util.*;
public class PalindromePartitioning {
    ArrayList<ArrayList<String>> partitions;
    
    public ArrayList<ArrayList<String>> partition(String s) {
        partitions = new ArrayList<ArrayList<String>>();
        dfs(s, 0, new ArrayList<String>());
        
        return partitions;       
    }
    
    private void dfs(String s, int start, ArrayList<String> prefix) {
        if (start == s.length()) {
           ArrayList<String> partition = new ArrayList<String>();
           partition.addAll(prefix);
           partitions.add(partition);
           return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                prefix.add(s.substring(start, i+1));             
                dfs(s, i+1, prefix);  
                prefix.remove(prefix.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++) {
            if(s.charAt(i) != s.charAt(start + end - i)) return false;
        }
        return true;
    }
}
