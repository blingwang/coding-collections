public class Solution {
    private char[][] board;
    private List<String> result;
    private TrieNode dictionary;
    private boolean[][] visited;
    private int m, n;
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        result = new ArrayList<String>();
        dictionary = buildTrie(words);
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, dictionary);
            }
        }
        
        return result;
    }
    
    private void dfs(int i, int j, TrieNode prefix) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        
        int index = board[i][j] - 'a';
        TrieNode curNode = prefix.next[index];
        
        if (curNode == null) return;
        
        if (curNode.word != null) {
            result.add(curNode.word);
            curNode.word = null; // dedup
        }
        
        visited[i][j] = true;
        
        dfs(i-1, j, curNode);
        dfs(i+1, j, curNode);
        dfs(i, j-1, curNode);
        dfs(i, j+1, curNode);
        
        visited[i][j] = false;
    }
    
    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode curNode = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (curNode.next[i] == null) {
                    curNode.next[i] = new TrieNode();
                }
                curNode = curNode.next[i];
            }
            curNode.word = word;
        }
        
        return root;
    }
    
    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
