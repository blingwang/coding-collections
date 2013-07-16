import java.util.*;

class Solution18Q13 {
    WordGroup[] groupList;
    private final int maxWordLength;
    private Trie trieList[];

    public Solution18Q13(String[] list) {
        groupList = createWordGroups(list);
        maxWordLength = groupList.length;
        trieList = new Trie[maxWordLength];
    }

    private WordGroup[] createWordGroups(String[] list) {
        /* Find length of the longest word. */
        int maxLength = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() > maxLength) {
                maxLength = list[i].length();
            }
        }

        /* Group the words in the dictionary into lists of words of same length */
        WordGroup[] groupList = new WordGroup[maxLength];
        for (int i = 0; i < list.length; i++) {
            String word = list[i];
            int groupIndex = word.length() - 1;
            if (groupList[groupIndex] == null) {
                groupList[groupIndex] = new WordGroup();
            }
            groupList[groupIndex].addWord(word);
        }

        return groupList;
    }

    public Rectangle maxRectangle() {
        int maxSize = maxWordLength * maxWordLength;
        for (int area = maxSize; area > 0; area--) { // start from biggest area
            // find possible length/width of rectangles: length * width = area 
            for (int l = 1; l * l <= area; l++) {
               if (area % l == 0) {
                  int w = area / l; 
                  if ( w <= maxWordLength) { // found valid length/width
                      Rectangle rect = makeRectangle(l, w);
                      if (rect != null) {
                          return rect;
                      }
                  }
               }
            }
        }
        return null;
    }

    Rectangle makeRectangle(int length, int width) {
        if (groupList[length - 1] == null || groupList[width - 1] == null) {
            return null;
        }

        /* Create trie for word width if we haven't yet */
        if (trieList[width - 1] == null) {
            Set<String> words = groupList[width - 1].getWords();
            trieList[width - 1] = new Trie();
            for(String word : words) {
                trieList[width - 1].put(word, true);
            }
        }

        return makePartialRectangle(length, width, new Rectangle(length));
    }

    private Rectangle makePartialRectangle(int length, int width, Rectangle rect) {
        if (rect.width == width) {
            if (rect.isComplete(length, width, groupList[width - 1])) {
                return rect;
            } else {
                return null;
            }
        }

        /* Compare columns to trie to see if potentially valid rectangle. */
        if (!rect.isPartialOK(length, trieList[width - 1])) {
            return null;
        }

        /* Go throught all words of the right length. Add each one to the current
         *  partial rectangle and attempt to build a rectangle recursively. */
        for (String word : groupList[length - 1].getWords()) {
            Rectangle extended = rect.append(word);
            Rectangle result = makePartialRectangle(length, width, extended);

            if (result != null) {
                return result;
            }
        }

        return null;
    }

    private class Rectangle {
        public final int length, width;
        public final char[][] matrix;

        public Rectangle(int l) {
            length = l;
            width = 0;
            matrix = null;// no need to new, width=0 will guard access
        }

        public Rectangle(int l, int w, char[][] letters) {
            assert(l == letters[0].length);
            assert(w == letters.length);

            length = l;
            width = w;
            matrix = letters;
        }

        public char getLetter(int i, int j) {
            return matrix[i][j];
        }

        public String getColumn(int col) {
            char[] letters = new char[width];
            for (int row = 0; row < width; row++) {
                letters[row] = getLetter(row, col);
            }

            return new String(letters);
        }

        /* Check if all columns are valid words. All rows are already known to
         * be valid since they were added directly from dictionary. */
        public boolean isComplete(int l, int w, WordGroup groupList) {
            if (width == w) {
                for (int i = 0; i < l; i++) {
                    String col = getColumn(i);
                    if (!groupList.containsWord(col)) {
                        return false;
                    }
                }
                return true;
            }

            return false;
        }

        public boolean isPartialOK(int l, Trie trie) {
            if (width == 0) return true;
            
            for (int i = 0; i < l; i++) {
                String col = getColumn(i);
                if (!trie.hasPrefix(col)) {
                    return false;
                }
            }

            return true;
        }

        /* Create a new Rectangle by taking the rows of the current rectangle and
         * and appending s. */
        public Rectangle append(String s) {
            assert(length == s.length());

            char[][] newMatrix = new char[length][width + 1];

            for (int i = 0; i < width; i++) {
                for(int j = 0; j < length; j++) {
                    newMatrix[i][j] = getLetter(i, j);
                }
            }

            for (int i = 0; i < s.length(); i++) {
                newMatrix[width + 1][i] = s.charAt(i);
            }

            return new Rectangle(length, width + 1, newMatrix);
        }
    }

    private class WordGroup {
        private Set<String> group = new HashSet<String>();

        public boolean containsWord(String s) {
            return group.contains(s);
        }

        public void addWord (String s) {
            group.add(s);
        }

        public int length() {
            return group.size();
        }

        public Set<String> getWords() {
            return group;
        }
    }

    private static class Trie {
        private static final int R = 26;
        private Node root = null;
        private static class Node {
            private boolean val;
            private Node[] next = new Node[R];
        }

        public boolean get(String key) {
            Node x = get(root, key, 0);
            if (x == null) return false;
            return x.val;
        }

        private Node get(Node x, String key, int d) {
            if (x == null) return null;
            if (d == key.length()) return x;
            char c = key.charAt(d); 
            return get(x.next[c], key, d+1);
        }

        public void put(String key, boolean val) {
            root = put(root, key, val, 0);
        }

        private Node put(Node x, String key, boolean val, int d) {
            if (x == null) {
                x = new Node();
            }

            if (d == key.length()) {
                x.val = val; 
                return x;
            }

            char c = key.charAt(d);
            x.next[c] = put(x.next[c], key, val, d+1);
            return x;
        }

        public boolean hasPrefix(String s) {
            return get(root, s, 0) != null;
        }
    }
}
