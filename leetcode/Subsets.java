import java.util.*;
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        assert(S.length <= 32);
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
}
