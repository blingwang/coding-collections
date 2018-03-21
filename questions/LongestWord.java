package com.blingwang.playground;

public class LongestWord {
    private Trie dictionary;
    private String longest = "";

    public String longestWord(String[] words, String charset) {
        dictionary = new Trie();
        for (String w : words) {
            dictionary.insert(w);
        }

        char[] chars = charset.toCharArray();
        enumerate(chars, "", 0);
        
        return longest;
    }

    private void enumerate(char[] chars, String prefix, int curIndex) {
        if (curIndex == chars.length || !dictionary.startsWith(prefix)) {
            return;
        }

        for (int i = curIndex; i < chars.length; i++) {
            swap(chars, curIndex, i);

            String newPrefix = prefix + chars[curIndex];
            if (dictionary.search(newPrefix) && newPrefix.length() > longest.length()) {
                longest = newPrefix;
            }
            
            enumerate(chars, newPrefix, curIndex + 1);
            swap(chars, curIndex, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        LongestWord lw = new LongestWord();
        String[] words = {"apple", "banana", "an", "apply", "yell"};
        String charset = "appyeslb";
        System.out.println(lw.longestWord(words, charset));
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private TrieNode insert(TrieNode node, String word, int depth) {
        if (node == null) {
            node = new TrieNode();
        }

        if (depth == word.length()) {
            node.isWord = true;
            return node;
        }

        int index = word.charAt(depth) - 'a';
        node.next[index] = insert(node.next[index], word, depth + 1);
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return  search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int depth) {
        if (node == null) return false;
        if (depth == word.length()) return node.isWord;

        int index = word.charAt(depth) - 'a';
        return search(node.next[index], word, depth + 1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(TrieNode node, String prefix, int depth) {
        if (node == null) return false;
        if (depth == prefix.length()) return true;

        int index = prefix.charAt(depth) - 'a';
        return startsWith(node.next[index], prefix, depth + 1);
    }

    private static class TrieNode {
        public boolean isWord;
        public TrieNode[] next = next = new TrieNode[26];
    }
}
