import java.util.*;
class Solution17Q14 {
    public static final Set<String> dictionary = new HashSet<String>();// use trie
    public String sentence;

    public Result parse(int wordStart, int wordEnd, HashMap<Integer, Result> cache) {
        if (wordEnd >= sentence.length()) {
            return new Result(wordEnd - wordStart, 
                              sentence.substring(wordStart).toUpperCase());
        }

        if (cache.containsKey(wordStart)) {
            return cache.get(wordStart).clone();
        }

        String currentWord = sentence.substring(wordStart, wordEnd + 1);
        boolean validPrefix = dictionary.contains(currentWord); // use prefix match

        /* break after current word */
        Result invalidAfterWord = parse(wordEnd + 1, wordEnd + 1, cache);
        if (dictionary.contains(currentWord)) {
            invalidAfterWord.parsed = currentWord.toUpperCase() + " " + 
                                      invalidAfterWord.parsed;
        } else {
            invalidAfterWord.invalid += currentWord.length();
        }
        
        /* extend current word */
        Result invalidWithWord = null;
        if (validPrefix) {
            invalidWithWord = parse(wordStart, wordEnd + 1, cache);
        }

        /* find minimum invalid count */
        Result minInvalid = Result.min(invalidAfterWord, invalidWithWord);
        cache.put(wordStart, minInvalid.clone());
        return minInvalid;
    }
}

class Result {
    public int invalid = Integer.MAX_VALUE;
    public String parsed = "";

    public Result(int inv, String p) {
        invalid = inv;
        parsed = p;
    }

    // prevent modification of Result objects in cache
    public Result clone() {
        return new Result(this.invalid, this.parsed);
    }

    public static Result min(Result r1, Result r2) {
        if (r1 == null) {
            return r2;
        } else if (r2 == null) {
            return r1;
        }

        return r2.invalid < r1.invalid ? r2 : r1;
    }
}

