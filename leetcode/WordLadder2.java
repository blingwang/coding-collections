import java.util.*;
public class WordLadder2 {
    private ArrayList<ArrayList<String>> ladders;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ladders = new ArrayList<ArrayList<String>>();
        int shortestLadderLength = Integer.MAX_VALUE;
        ArrayDeque<String> queue = new ArrayDeque<String>();
        Map<String, Integer> distTo = new HashMap<String, Integer>();
        Map<String, ArrayList<String>> edgesTo = new HashMap<String, ArrayList<String>>();
        queue.offer(start);
        distTo.put(start, 1);
        
        while (!queue.isEmpty()) {
            String w = queue.poll();
            if (distTo.get(w) > shortestLadderLength - 1) break;
            for (String v : getOneEditWords(w, dict)) {
                if (distTo.containsKey(v)) { // visited, go no further
                    if (distTo.get(v) == distTo.get(w)+1) {
                        edgesTo.get(v).add(w); // one more path with min distance
                    }
                    
                } else {
                    queue.offer(v);
                    distTo.put(v, distTo.get(w)+1);
                    ArrayList<String> edges = new ArrayList<String>();
                    edges.add(w);
                    edgesTo.put(v, edges);
                    
                    if (v.equals(end)) { // found end 
                        shortestLadderLength = distTo.get(w) + 1;
                        break; // no more edges from w to end
                    }
                }         
            }
        }
        
        if (shortestLadderLength != Integer.MAX_VALUE) { // at least one path found
            String[] editPath = new String[shortestLadderLength];
            enumerateEditPaths(end, edgesTo, editPath, editPath.length-1);
        }
        
        return ladders;
    }

    private void enumerateEditPaths(String end, Map<String, ArrayList<String>> edgesTo,
                                    String[] editPath, int endIndex) {
        editPath[endIndex] = end; // append current end to path
        
        if (!edgesTo.containsKey(end)) { // found start, add ladder
            addLadder(editPath);
            return;
        }
        
        for (String w : edgesTo.get(end)) {
            enumerateEditPaths(w, edgesTo, editPath, endIndex-1);
        }
    }
    
    private void addLadder(String[] editPath) {
        ArrayList<String> ladder = new ArrayList<String>();
        for (String s : editPath) {
            ladder.add(s);
        }
        ladders.add(ladder);
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
