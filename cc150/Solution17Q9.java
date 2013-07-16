import java.util.*;
class Solution17Q9 {
    private HashMap<String, Integer> table;

    public Solution17Q9(String[] book) {
        setupDictionary(book);
    }

    private void setupDictionary(String[] book) {
        table = new HashMap<String, Integer>();

        // count word and put in table
        for (String word : book) {
            word = word.toLowerCase().trim();
            if (word != "") {
                if (!table.containsKey(word)) {
                    table.put(word,1);
                } else {
                    table.put(word, table.get(word) + 1);
                }
            }
        }
    }

    public int getFrequency(String word) {
        if (table == null || word == null) return -1;

        word = word.toLowerCase();
        if (table.containsKey(word)) {
            return table.get(word);
        }

        return 0;
    }
}
