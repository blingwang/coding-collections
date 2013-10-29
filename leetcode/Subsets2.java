import java.util.*;
public class Subsets2 {
    int n;
    int[] numbers;
    int[] numCounts;
    int[] subset;
    ArrayList<ArrayList<Integer>> allSubsets;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        n = countDistinctNumbers(num);
        numbers = new int[n];
        numCounts = new int[n];
        subset = new int[n];
        allSubsets = new ArrayList<ArrayList<Integer>>();
        
        if (num.length == 0) return allSubsets;
        
        countNumbers(num);
        enumerate(0);
        return allSubsets;
    }

    private void enumerate(int numIndex) {
        if (numIndex == n) {
            addSubset();
            return;
        }
        
        for (int i = 0; i <= numCounts[numIndex]; i++) {
            subset[numIndex] = i;
            enumerate(numIndex + 1);
        }
    }

    private int countDistinctNumbers(int[] num) {
        int count = 1;
        int pre = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] != pre) {
                count++;
                pre = num[i];
            }
        }
        return count;
    }

    private void countNumbers(int[] num) {
        int pre = num[0];
        int count = 1;
        int numIndex = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == pre) {
                count++;
            } else {
                numbers[numIndex] = pre;
                numCounts[numIndex] = count;
                numIndex++;
                pre = num[i];
                count = 1;
            }
        }
        
        numbers[numIndex] = pre;
        numCounts[numIndex] = count;
    }

    private void addSubset() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < subset[i]; j++) {
                list.add(numbers[i]);
            }
        }
        allSubsets.add(list);
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        int numDups = 0; // pre dups count
        for (int i = 0; i < num.length; i++) {
            int count = subsets.size();
            
            // count duplicates so far
            if (i > 0 && num[i] == num[i-1]) numDups++;
            else numDups = 0;
            
            for (int j = 0; j < count; j++) {
                // only append to subsets containing all previous duplicates
                ArrayList<Integer> pre = subsets.get(j);
                if (numDups > 0 && (pre.size() < numDups || 
                                    pre.get(pre.size()-numDups) != num[i])) continue;
                
                ArrayList<Integer> subset = new ArrayList<Integer>();
                subset.addAll(subsets.get(j));
                subset.add(num[i]);
                subsets.add(subset);
            }
        }
        
        return subsets;
    }
    
    /*
     * 1). Add [] to results 
     * 2). Add each single distinct element to results and recursively 
     *     append the rest of elements to each subset.
     * grow each max-size set by adding each distinct num after last num in the set
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup3(int[] num) {// recursion
        Arrays.sort(num);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        return subsetsWithDupHelper(num, 0, subset, subsets);
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDupHelper(int[] num, int cur, 
                ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> subsets) {
        subsets.add(subset);
        
        for(int i = cur; i < num.length; i++) {
            if (i > cur && num[i] == num[i-1]) continue;// skip dups
            
            ArrayList<Integer> newSet = new ArrayList<Integer>(subset);
            newSet.add(num[i]);
            subsets = subsetsWithDupHelper(num, i+1, newSet, subsets);
        }
        
        return subsets;
    }
}
