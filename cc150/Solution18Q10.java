import java.util.*;
class Solution18Q10 {
    public LinkedList<String> transform(String startWord, String stopWord,
                                        Set<String> dictionary) {
        assert(!startWord.equals(stopWord));

        startWord = startWord.toUpperCase();
        stopWord = stopWord.toUpperCase();
        Queue<String> toVisit = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        Map<String, String> parents = new TreeMap<String, String>();

        // BFS
        toVisit.add(startWord);
        visited.add(startWord);
        
        while (!toVisit.isEmpty()) {
            String w = toVisit.poll();
            for (String v : getOneEditWords(w, dictionary)) {
                if (!visited.contains(v)) {
                    toVisit.add(v);
                    visited.add(v);
                    parents.put(v, w);
                }

                if (v.equals(stopWord)) {
                    return getEditPath(startWord, parents);
                }
            }
        }
        return null;
    }

    private LinkedList<String> getEditPath(String w, Map<String, String> parents) {
        LinkedList<String> list = new LinkedList<String>();
        while (w != null) {
            list.add(0, w);
            w = parents.get(w);
        }

        return list;
    }

    private Set<String> getOneEditWords(String word, Set<String> dictionary) {
        Set<String> words = new TreeSet<String>();
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char curChar = wordArray[i];
            for (char c = 'A'; c <= 'Z'; c++) {
                if (c != word.charAt(i)) {
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    if (dictionary.contains(newWord)) {
                        words.add(newWord);
                    }
                }
            }
            wordArray[i] = curChar; // clean up
        }

        return words;
    }
}
