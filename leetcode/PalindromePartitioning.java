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
           ArrayList<String> partition = new ArrayList<String>(prefix);
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
    
    private Map<Integer, ArrayList<ArrayList<String>>> cache;
    private boolean[][] isPalindrome;
    public ArrayList<ArrayList<String>> partitionDP(String s) {
        if (s == null || s.length() == 0) return new ArrayList<ArrayList<String>>();
        //cache = new HashMap<Integer, ArrayList<ArrayList<String>>>();
        isPalindrome = new boolean[s.length()][s.length()];
        computePalindromes(s);
        //return partition(s, 0);
        return partitionIter(s);
    }
    
    private ArrayList<ArrayList<String>> partition(String s, int start) {
        if (cache.containsKey(start)) return cache.get(start);
        
        ArrayList<ArrayList<String>> partitionList = new ArrayList<ArrayList<String>>();
        if (start == s.length()) {
            partitionList.add(new ArrayList<String>());
            return partitionList;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {
                for (ArrayList<String> partition : partition(s, i+1)) {
                    // create new partition to avoid modifying cache
                    ArrayList<String> newPartition = new ArrayList<String>();
                    newPartition.add(s.substring(start, i+1));
                    newPartition.addAll(partition);
                    partitionList.add(newPartition);
                }
            }
        }
        
        cache.put(start, partitionList);
        return partitionList;
    }
    
    private ArrayList<ArrayList<String>> partitionIter(String s) {
        Map<Integer, ArrayList<ArrayList<String>>> cache = new HashMap<Integer, 
                                                ArrayList<ArrayList<String>>>();
        
        ArrayList<ArrayList<String>> lastPartitions = new ArrayList<ArrayList<String>>();
        lastPartitions.add(new ArrayList<String>());
        cache.put(s.length(), lastPartitions);
        
        for (int i = s.length() - 1; i >= 0; i--) {
            ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>();
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome[i][j]) {
                    for (ArrayList<String> partition : cache.get(j+1)) {
                        ArrayList<String> newPartition = new ArrayList<String>();
                        newPartition.add(s.substring(i, j+1));
                        newPartition.addAll(partition);
                        partitions.add(newPartition);
                    }
                }
            }
            cache.put(i, partitions);
        }
        return cache.get(0);
    }
    
    private void computePalindromes(String s) {//dp to compute palindromes
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }  
        
        for (int i = s.length() - 2; i >= 0; i--) {
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
            for (int j = i + 2; j < s.length(); j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && 
                                     isPalindrome[i+1][j-1];
            }
        }
    }
    
    private boolean isPalindrome2(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
