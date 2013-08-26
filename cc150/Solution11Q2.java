import java.util.*;
class Solution11Q2 {
    public void groupAnagrams(String[] array) {
        HashMap<String, ArrayList<String>> hmap = new 
            HashMap<String, ArrayList<String>>();

        // Group words by anagram into hashtable
        for (String word : array) {
            String key = sortChars(word);
            if (!hmap.containsKey(key)) {
                hmap.put(key, new ArrayList<String>());
            }
            
            ArrayList<String> anagrams = hmap.get(key);
            anagrams.add(word);
        }

        // convert hash table to array
        int index = 0;
        for (String key : hmap.keySet()) {
            ArrayList<String> list = hmap.get(key);
            for (String word : list) {
                array[index] = word;
                index++;
            }
        }
    }

    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
