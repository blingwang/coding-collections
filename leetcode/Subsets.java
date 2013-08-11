import java.util.*;
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        assert(S.length <= 31);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        int count = 1 << S.length;
        for (int i = 0; i < count; i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < S.length; j++) {
                if (((i >> j) & 1) == 1) subset.add(S[j]);
            }
            list.add(subset);
        }
        return list;
    }
    
    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        Arrays.sort(S);
        return subsetsHelper(S, 0);
    }
    
    private ArrayList<ArrayList<Integer>> subsetsHelper(int[] S, int cur) {
        if (cur >= S.length) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
            results.add(new ArrayList<Integer>());
            return results;
        }  
        
        ArrayList<ArrayList<Integer>> results = subsetsHelper(S, cur+1);
        int count = results.size();
        for (int i = 0; i < count; i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            subset.add(S[cur]);
            subset.addAll(results.get(i));
            results.add(subset);
        }
        
        return results;
    }
    
    public ArrayList<ArrayList<Integer>> subsets3(int[] S) {
        Arrays.sort(S);
        
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        for (int i = 0; i < S.length; i++) {
            int count = subsets.size();
            for (int j = 0; j < count; j++) {
                ArrayList<Integer> subset = new ArrayList<Integer>();
                subset.addAll(subsets.get(j));
                subset.add(S[i]);
                subsets.add(subset);
            }
        }
        
        return subsets;
    }
}
