import java.util.*;
class Solution9Q4 {
    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        return getSubsets(set, 0);
    }

    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) { // Base case - add empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // empty set
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = 
                new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    // generate subsets based on binary string, subset.size()<32
    ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        assert(set.size() < 32);
        ArrayList<ArrayList<Integer>> allsubsets = 
            new ArrayList<ArrayList<Integer>>();
        int max = 1 << (set.size() - 1); // compute 2^n-1
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset);
        }

        return allsubsets;
    }

    private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
           if ((k & 1) == 1) {
              subset.add(set.get(index));
           }
          index++;
        }
        return subset;
    } 
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        for (int i = 0; i < set.size(); i++) {// adding each element
            int count = subsets.size();
            for (int j = 0; j < count; j++) {
                ArrayList<Integer> subset = new ArrayList<Integer>();
                subset.addAll(subsets.get(j));
                subset.add(set.get(i));
                subsets.add(subset);
            }
        }
        
        return subsets;
    }
    
    public static ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        
        enumerate(set, subsets, prefix, 0);
        
        return subsets;
    }
    
    private static void enumerate(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> subsets,
                                  ArrayList<Integer> prefix, int k) {
        if (k == set.size()) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            subset.addAll(prefix);
            subsets.add(subset);
            return;
        }
        
        enumerate(set, subsets, prefix, k+1);
        prefix.add(set.get(k));
        enumerate(set, subsets, prefix, k + 1);
        prefix.remove(prefix.size() - 1);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1,2,3};
        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int i : a) {
            set.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = subsets2(set);
        for (ArrayList<Integer> subset : subsets) {
            for (int i : subset) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
}
