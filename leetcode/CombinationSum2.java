import java.util.*;
public class CombinationSum2 {
    int[] candidates;
    ArrayList<ArrayList<Integer>> combList;
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        candidates = num;
        combList = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(candidates);
        boolean[] inCombination = new boolean[candidates.length];
        combine(0, target, inCombination);
        
        return combList;
    }
    
    private void combine(int k, int target, boolean[] inCombination) {
        if (target == 0) {
            addCombination(inCombination);
            return;
        }
        
        if (target < 0 || k == candidates.length) return;
        
        combine(k+1, target, inCombination);
        
        if (preDupSkipped(k, inCombination)) return;
        
        inCombination[k] = true;
        combine(k+1, target-candidates[k], inCombination);
        
        inCombination[k] = false;
    }
    
    private void addCombination(boolean[] inCombination) {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        for (int i = 0; i < inCombination.length; i++) {
            if (inCombination[i]) {
                combination.add(candidates[i]);
            }
        }
        combList.add(combination);
    }
    
    private boolean preDupSkipped(int k, boolean[] inCombination) {
        return k > 0 && candidates[k] == candidates[k-1] && !inCombination[k-1];
    }
}
