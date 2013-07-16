import java.util.*;
public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        ArrayDeque<String> queue = new ArrayDeque<String>();
        Map<String, Integer> distTo = new HashMap<String, Integer>();
        queue.offer(start);
        distTo.put(start, 1);
        
        while (!queue.isEmpty()) {
            String w = queue.poll();
            for (String v : getOneEditWords(w, dict)) {
                if (v.equals(end)) return distTo.get(w) + 1;
                if (!distTo.containsKey(v)) {
                    queue.offer(v);
                    distTo.put(v, distTo.get(w) + 1);
                }
            }
        }
        
        return 0;
    }

    private Set<String> getOneEditWords(String word, HashSet<String> dict) {
        Set<String> words = new HashSet<String>();
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char curChar = wordArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == wordArray[i]) continue;
                wordArray[i] = c;
                String w = new String(wordArray);
                if (dict.contains(w)) words.add(w);
            }
            wordArray[i] = curChar; // clean up
        }
        return words;
    }
}
