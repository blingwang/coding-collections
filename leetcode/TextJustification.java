import java.util.*;
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        if (words.length == 0) return result;
        
        int start = 0, wordsLen = 0;    
        for (int i = 0; i < words.length; i++) {
            if (wordsLen + words[i].length() + (i-start) > L) {
                result.add(buildLine(words, start, i-1, L, wordsLen, false));
                start = i;
                wordsLen = 0;
            }
            wordsLen += words[i].length();
        }  
        
        result.add(buildLine(words, start, words.length-1, L, wordsLen, true));
        
        return result;
    }

    private String buildLine(String[] words, int start, int end, int L, 
                             int wordsLen, boolean leftJustified) {
        assert(start >= 0 && end < words.length && start <= end);
        StringBuilder line = new StringBuilder();
        
        int wordCount = end - start + 1;
        if (wordCount == 1) leftJustified = true;
        
        int spacesPerWord = 1;
        int extraSpaces = 0;
        
        if (!leftJustified) {
            spacesPerWord = (L-wordsLen)/(wordCount-1);
            extraSpaces = (L-wordsLen) % (wordCount-1);
        }
        
        line.append(words[start]);
        for (int i = 1; i < wordCount; i++) {
            int numSpaces = spacesPerWord;
            if (i <= extraSpaces) numSpaces++;        
            appendSpaces(line, numSpaces);
            line.append(words[start+i]);
        }
        
        if (line.length() < L) {
            appendSpaces(line, L - line.length());
        }
        
        return line.toString();
    }

    private void appendSpaces(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
    }
}
