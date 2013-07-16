import java.util.*;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if ( i > 0 && num[i] == num[i-1]) continue;
            // Do two sum
            int start = i + 1; 
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    int curStart = num[start];
                    int curEnd = num[end];
                    ArrayList<Integer> triplet = new ArrayList<Integer>(3);
                    triplet.add(num[i]);
                    triplet.add(curStart);
                    triplet.add(curEnd);
                    result.add(triplet);
                    while(start < end &&  num[start] == curStart) {
                        start++;
                    }
                    while(end > start && num[end] == curEnd) {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
