import java.util.*;

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        // Add words into hash table with sorted chars as key
        Map<String, ArrayList<String>> anagramTable = new 
                                HashMap<String, ArrayList<String>>();
        for (String word : strs) {
            String key = getKey(word);
            if (!anagramTable.containsKey(key)) {
                ArrayList<String> anagramList = new ArrayList<String>();
                anagramTable.put(key, anagramList);
            }
            
            ArrayList<String> anagramList = anagramTable.get(key);
            anagramList.add(word);
        }

        // output anagrams from hashtable to array list, group by key
        ArrayList<String> result = new ArrayList<String>();
        for (ArrayList<String> anagramList : anagramTable.values()) {
            if (anagramList.size() > 1) {
                 result.addAll(anagramList);
            }         
        }

        return result;
    }

    private String getKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
