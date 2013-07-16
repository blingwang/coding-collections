import java.util.*;
class Solution11Q2 {
    public void groupAnagrams(String[] array) {
        HashMap<String, LinkedList<String>> hmap = new 
            HashMap<String, LinkedList<String>>();

        // Group words by anagram
        for (String word : array) {
            String key = sortChars(word);
            if (!hmap.containsKey(key)) {
                hmap.put(key, new LinkedList<String>());
            }
            
            LinkedList<String> anagrams = hmap.get(key);
            anagrams.push(word);
        }

        // convert hash table to array
        int index = 0;
        for (String key : hmap.keySet()) {
            LinkedList<String> list = hmap.get(key);
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
