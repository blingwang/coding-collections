import java.util.*;
public class WordLadder2 {
    private ArrayList<ArrayList<String>> editPaths;
    private Map<String, Integer> distTo;
    private Map<String, ArrayList<String>> edgesTo;
    private int minDist;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        editPaths = new ArrayList<ArrayList<String>>();
        distTo = new HashMap<String, Integer>();
        edgesTo = new HashMap<String, ArrayList<String>>();
        minDist = Integer.MAX_VALUE;
        ArrayDeque<String> queue = new ArrayDeque<String>();
        
        queue.offer(start);
        distTo.put(start, 1);
        
        while (!queue.isEmpty()) {
            String w = queue.poll();
            if (distTo.get(w) >= minDist) break;
            
            for (String v : oneEditWords(w, dict)) {
                if (v.equals(end) && !distTo.containsKey(v)) {
                    minDist = distTo.get(w) + 1;
                }
                
                if (!distTo.containsKey(v)) {
                    queue.offer(v);
                    distTo.put(v, distTo.get(w) + 1);
                    addEdge(w, v);
                } else if (distTo.get(v) == distTo.get(w)+1) {
                    addEdge(w, v);
                }
            }
        }
        
        if (minDist != Integer.MAX_VALUE) {
            enumerateEditPaths(minDist-1, end, new String[minDist]);
        }
        
        return editPaths;
    }
    
    private void addEdge(String from, String to) {
        if (!edgesTo.containsKey(to)) {
            edgesTo.put(to, new ArrayList<String>());
        }
        
        edgesTo.get(to).add(from);
    }
    
    private void enumerateEditPaths(int curIndex, String curWord, String[] editPath) {
        editPath[curIndex] = curWord;
        
        if (curIndex == 0) {
            addEditPath(editPath);
            return;
        }
        
        for (String parent : edgesTo.get(curWord)) {
            enumerateEditPaths(curIndex-1, parent, editPath);
        }
    }
    
    private void addEditPath(String[] editPath) {
        ArrayList<String> path = new ArrayList<String>();
        for (String word : editPath) {
            path.add(word);
        }
        editPaths.add(path);
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

class WordLadder2DFS { // DFS search for paths, slower
    ArrayList<ArrayList<String>> ladders;
    private HashSet<String> dict;
    private HashSet<String> marked;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dictionary) {
        ladders = new ArrayList<ArrayList<String>>();
        dict = dictionary;
        marked = new HashSet<String>();
        int ladderLength = ladderLength(start, end);
        if (ladderLength > 0){
            String[] editPath = new String[ladderLength];
                    enumerateEditPaths(start, end, editPath, 0);
        }
        return ladders;
    }
    
    private void enumerateEditPaths(String source, String end, 
                                    String[] editPath, int srcIndex) {
        editPath[srcIndex] = source;
        
        if (srcIndex == editPath.length-1) {
            if (source.equals(end)){
                addLadder(editPath);
                }
            return;
        }
        
        marked.add(source);
        for (String w : getOneEditWords(source)) {
            enumerateEditPaths(w, end, editPath, srcIndex+1);
        }
        marked.remove(source);
    }
    
    private void addLadder(String[] editPath) {
        ArrayList<String> ladder = new ArrayList<String>();
        for (String s : editPath) {
            ladder.add(s);
        }
        ladders.add(ladder);
    }
    
    private int ladderLength(String start, String end) {
        ArrayDeque<String> queue = new ArrayDeque<String>();
        Map<String, Integer> distTo = new HashMap<String, Integer>();
        queue.offer(start);
        distTo.put(start, 1);
        
        while (!queue.isEmpty()) {
            String w = queue.poll();
            for (String v : getOneEditWords(w)) {
                if (v.equals(end)) return distTo.get(w) + 1;
                if (!distTo.containsKey(v)) {
                    queue.offer(v);
                    distTo.put(v, distTo.get(w) + 1);
                }
            }
        }
        
        return 0;
    }
    
    private Set<String> getOneEditWords(String word) {
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
