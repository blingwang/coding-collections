import java.util.*;
public class CombinationSum {
    private int[] candidates;
    private int[] count;
    private ArrayList<ArrayList<Integer>> combList;
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        count = new int[candidates.length];
        combList = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(candidates); // not necessary
        enumerate(0, target);
        
        return combList;
    }
    
    private void enumerate(int candidateIndex, int target) {
        if (target == 0) {
            process();
            return;
        }
        
        if (candidateIndex >= candidates.length) return;
        int candidate = candidates[candidateIndex];
        if (candidate > target) return; //candidates in sorted order
        
        for (int i = 0; i * candidate <= target; i++) {
            count[candidateIndex] = i;
            enumerate(candidateIndex + 1, target - i * candidate);
        }
        
        count[candidateIndex] = 0;
    }
    
    private void process() {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                combination.add(candidates[i]);
            }
        }
        combList.add(combination);
    }
}
