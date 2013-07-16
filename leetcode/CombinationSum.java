import java.util.*;
public class CombinationSum {
    ArrayList<ArrayList<Integer>> list;
    int[] candidates;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        this.candidates = candidates;
        int[] prefix = new int[candidates.length];
        enumerate(0, target, prefix);
        return list;
    }

    private void enumerate(int candidateIndex, int target, int[] prefix) {
        if (target == 0) {
            list.add(getCombinationList(prefix));
            return;
        }
        
        if (candidateIndex == candidates.length) return;
        
        int candidate = candidates[candidateIndex];
        for (int i = 0; i * candidate <= target; i++) {
            prefix[candidateIndex] = i;
            enumerate(candidateIndex+1, target - i * candidate, prefix); 
        }
        prefix[candidateIndex] = 0;
    }

    private ArrayList<Integer> getCombinationList(int[] counts) {
        ArrayList<Integer> combList = new ArrayList<Integer>();
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                combList.add(candidates[i]);
            }
        }
        return combList;
    }
}
