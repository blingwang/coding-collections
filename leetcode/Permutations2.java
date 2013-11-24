import java.util.*;
public class Permutations2 {
    private int[] a;
    private ArrayList<ArrayList<Integer>> permutations;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        a = num;
        permutations = new ArrayList<ArrayList<Integer>>();
        enumerate(0);
        return permutations;
    }

    private void enumerate(int k) {
        if (k == a.length) {
            process();
            return;
        }
        
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int i = k; i < a.length; i++) {
            if (seen.contains(a[i])) continue;
            seen.add(a[i]);
            exch(a, k, i);
            enumerate(k+1);
            exch(a, k, i);
        }
    }

    private void process() {       
        ArrayList<Integer> perm = new ArrayList<Integer>();
        for (int i : a) {
            perm.add(i);
        }
        permutations.add(perm);
    }

    private void exch(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
