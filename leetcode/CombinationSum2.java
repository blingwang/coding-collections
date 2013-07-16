import java.util.*;
public class CombinationSum2 {
    ArrayList<ArrayList<Integer>> list;
    int[] candidates;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        list = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        this.candidates = num;
        int[] prefix = new int[candidates.length];
        enumerate(0, target, prefix);
        return list;
    }

    private void enumerate(int candidateIndex, int target, int[] prefix) {
        if (target == 0) {
            list.add(getCombinationList(prefix));
            return;
        }
        
        if (target < 0 || candidateIndex == candidates.length) return;
        
        int candidate = candidates[candidateIndex];
        enumerate(candidateIndex+1, target, prefix);
        
        if (candidateIndex >= 1 && candidate == candidates[candidateIndex-1] &&
            prefix[candidateIndex-1] == 0) {
            return;
        }
        
        prefix[candidateIndex] = 1;
        enumerate(candidateIndex+1, target - candidate, prefix);
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
