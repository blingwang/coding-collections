import java.util.*;
public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        ArrayDeque<String> queue = new ArrayDeque<String>();
        Map<String, Integer> distTo = new HashMap<String, Integer>();
        
        queue.offer(start);
        distTo.put(start, 1);
        
        while (!queue.isEmpty()) {
            String w = queue.poll();
            for (String v : oneEditWords(w, dict)) {
                if (v.equals(end)) return distTo.get(w) + 1;
                if (!distTo.containsKey(v)) {
                    queue.offer(v);
                    distTo.put(v, distTo.get(w) + 1);
                }
            }
        }
        
        return 0;
    }
    
    private Set<String> oneEditWords(String word, HashSet<String> dict) {
        Set<String> words = new HashSet<String>();
        char[] letters = word.toCharArray();
        
        for (int i = 0; i < letters.length; i++) {
            char curLetter = letters[i];
            
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == curLetter) continue;
                letters[i] = c;
                String candidate = new String(letters);
                if (dict.contains(candidate)) words.add(candidate);
            }
            
            letters[i] = curLetter;
        }
        
        return words;
    }
}
