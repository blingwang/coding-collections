import java.util.*;
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int lengthS = S.length();
        int lengthT = T.length();
        
        if (lengthS == 0 || lengthT == 0) return 0;
        int[] numSuffix = new int[lengthT];
        Map<Character, ArrayList<Integer>> charIndexMap = new HashMap<Character, ArrayList<Integer>>();
        
        for (int i = 0; i < lengthT; i++) {
            char c = T.charAt(i);
            if (!charIndexMap.containsKey(c)) {
                ArrayList<Integer> indice = new ArrayList<Integer>();
                charIndexMap.put(c, indice);
            }
            
            ArrayList<Integer> indice = charIndexMap.get(c);
            indice.add(i);
        }
        
        for (int i = lengthS - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (charIndexMap.containsKey(c)) {
                ArrayList<Integer> indice = charIndexMap.get(c);
                for (int index : indice) {
                    if (index == lengthT - 1) {
                        numSuffix[index]++;
                    } else {
                        numSuffix[index] += numSuffix[index+1];
                    }       
                }
            }
        }
        
        return numSuffix[0];
    }
}
