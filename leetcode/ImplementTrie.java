class TrieNode {
    public boolean isWord;
    public TrieNode[] next;
    
    public TrieNode() {
        isWord = false;
        next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        root = insert(root, word, 0);    
    }
    
    private TrieNode insert(TrieNode x, String word, int d) {
        if (x == null) x = new TrieNode();
        
        if (d == word.length()) {
            x.isWord = true;
            return x;
        }
        
        int index = word.charAt(d) - 'a';
        x.next[index] = insert(x.next[index], word, d+1);
        
        return x;
    }

    public boolean search(String word) {
        return search(root, word, 0);    
    }
    
    private boolean search(TrieNode x, String word, int d) {
        if (x == null) return false;
        if (d == word.length()) return x.isWord;
        
        int index = word.charAt(d) - 'a';
        return search(x.next[index], word, d+1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);   
    }
    
    private boolean startsWith(TrieNode x, String prefix, int d) {
        if (x == null) return false;
        if (d == prefix.length()) return true;
        
        int index = prefix.charAt(d) - 'a';
        return startsWith(x.next[index], prefix, d+1);
    }
}
