import java.util.*;
public class TextJustification {
    private String[] words;
    private int L;
    
    public ArrayList<String> fullJustify(String[] words, int L) {
        this.words = words;
        this.L = L;
        ArrayList<String> result = new ArrayList<String>();
        if (words.length == 0) return result;
        
        int start = 0;
        int wordsLength = words[0].length();
        for (int i = 1; i < words.length; i++) {
            int minSpacesLength = i - start;
            if (wordsLength + minSpacesLength + words[i].length() > L) {
                result.add(buildLine(start, i-1, wordsLength, false));
                start = i;
                wordsLength = words[i].length();
            } else {
                wordsLength += words[i].length();
            }
        }
        
        result.add(buildLine(start, words.length-1, wordsLength, true));
        
        return result;
    }
    
    private String buildLine(int start, int end, int wordsLength, boolean leftJustified) {
        assert(start >= 0 && end < words.length && start <= end);
        StringBuilder line = new StringBuilder();
        
        int wordCount = end - start + 1;
        if (wordCount == 1) leftJustified = true;
        
        int spacesPerWord = 1;
        int extraSpaces = 0;
        if (!leftJustified) {
            int spacesNeeded = L - wordsLength;
            spacesPerWord = spacesNeeded / (wordCount - 1);
            extraSpaces = spacesNeeded % (wordCount - 1);
        }
        
        for (int i = start; i < end; i++) {
            line.append(words[i]);
            
            int numSpaces = spacesPerWord;
            int extraSpacesSoFar = i - start;
            if (extraSpacesSoFar < extraSpaces) numSpaces++;
            
            appendSpaces(line, numSpaces);
        }
        
        line.append(words[end]);
        
        if (line.length() < L) {
            appendSpaces(line, L - line.length());
        }
        
        return line.toString();
    }
    
    private void appendSpaces(StringBuilder line, int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            line.append(' ');
        }
    }
}
