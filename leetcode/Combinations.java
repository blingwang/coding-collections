import java.util.*;
public class Combinations {
    private ArrayList<ArrayList<Integer>> combList;
    private int[] combination;
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        assert(n >= k);
        combList = new ArrayList<ArrayList<Integer>>();
        combination = new int[k];
        enumerate(n, k);
        return combList;
    }
    
    private void enumerate(int n, int k) {
        if (n < k) return;
        
        if (k == 0) {
            process();
            return;
        }
        
        enumerate(n-1, k);
        combination[k-1] = n;
        enumerate(n-1, k-1);
    }
    
    private void process() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : combination) {
            list.add(i);
        }
        combList.add(list);
    }
}
