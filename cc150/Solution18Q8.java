import java.util.*;
class Solution18Q8 {}
class SuffixTree {
    SuffixTreeNode root = new SuffixTreeNode();
    public SuffixTree(String s) {
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            root.insertString(suffix, i);
        }
    }

    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }

    private class SuffixTreeNode {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        HashMap<Character, SuffixTreeNode> children = new 
                                            HashMap<Character, SuffixTreeNode>();
        
        public SuffixTreeNode() {}

        public void insertString(String s, int index) {
            indexes.add(index);
            if (s != null && s.length() > 0) {
                char value = s.charAt(0);
                SuffixTreeNode child = null;
                if (children.containsKey(value)) {
                    child = children.get(value);
                } else {
                    child = new SuffixTreeNode();
                    children.put(value, child);
                }

                String remainder = s.substring(1);
                child.insertString(remainder, index);
            }
        }

        public ArrayList<Integer> search(String s) {
            if (s == null || s.length() == 0) {
                return indexes;
            } else {
                char first = s.charAt(0);
                if (children.containsKey(first)) {
                    String remainder = s.substring(1);
                    return children.get(first).search(remainder);
                }
            }
            return null;
        }
    }
}
