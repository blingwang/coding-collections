import java.util.*;

public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);            
        }
        return new ArrayList<List<String>>(map.values());
    }
    
    // return sorted anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramTable = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            if (!anagramTable.containsKey(key)) {
                anagramTable.put(key, new ArrayList<String>());
            }
            
            anagramTable.get(key).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> anagramList : anagramTable.values()) {
            // Another solution is using a tree set, then new ArrayList<T>(set)
            Collections.sort(anagramList);
            result.add(anagramList);
        }
        
        return result;
    }
    
    // corner cases: empty strings; distinct word
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
