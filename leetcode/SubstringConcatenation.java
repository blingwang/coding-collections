import java.util.*;
public class SubstringConcatenation {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int wordLength = L[0].length();
        int concatLength = wordLength * L.length;
        if (S.length() < concatLength) return indices;
        
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        
        for (String word : L) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 0);
            }
            int count = wordCount.get(word);
            wordCount.put(word, count+1);
        }
        
        for (int i = 0; S.length() - i >= concatLength; i++) {
            Map<String, Integer> hasFound = new HashMap<String, Integer>();
            int j = 0;
            while (j * wordLength < concatLength) {
                String word = S.substring(i+wordLength*j, i+wordLength*(j+1));
                if (!wordCount.containsKey(word)) break;
                if (!hasFound.containsKey(word)) {
                    hasFound.put(word, 0);
                }
                int foundCount = hasFound.get(word)+1;
                if (foundCount > wordCount.get(word)) {
                    break;
                } else {
                    hasFound.put(word, foundCount);
                    j++;
                }
            }
            if ( j * wordLength == concatLength) indices.add(i);
        }
        
        return indices;
    }
}
