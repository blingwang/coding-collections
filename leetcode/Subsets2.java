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
}
