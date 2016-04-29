public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        root = addWord(root, word, 0);    
    }
    
    private TrieNode addWord(TrieNode x, String word, int d) {
        if (x == null) x = new TrieNode();
        
        if (d == word.length()) {
            x.isWord = true;
            return x;
        }
        
        int index = word.charAt(d) - 'a';
        x.next[index] = addWord(x.next[index], word, d+1);
        
        return x;
    }

    public boolean search(String word) {
        return search(root, word, 0);    
    }
    
    private boolean search(TrieNode x, String word, int d) {
        if (x == null) return false;
        if (d == word.length()) return x.isWord;
        
        char c = word.charAt(d);
        if (c == '.') {
            for (TrieNode n : x.next) {
                if (n != null && search(n, word, d+1)) return true;
            }
        } else {
            return search(x.next[c-'a'], word, d+1);    
        }
        
        return false;
    }
    
    private static class TrieNode {
        boolean isWord;
        TrieNode[] next;
        
        TrieNode() {
            isWord = false;
            next = new TrieNode[26];
        }
    }
}
