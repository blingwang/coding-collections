import java.util.*;
class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if ( i > 0 && num[i] == num[i-1]) continue; 
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j-1]) continue;
                // Do two sum
                int expected = target-(num[i] + num[j]);
                int start = j + 1; 
                int end = num.length - 1;
                while (start < end) {
                    int sum = num[start] + num[end];
                    if (sum < expected) {
                        start++;
                    } else if (sum > expected) {
                        end--;
                    } else {
                        int curStart = num[start];
                        int curEnd = num[end];
                        ArrayList<Integer> quadruplet = new ArrayList<Integer>(4);
                        quadruplet.add(num[i]);
                        quadruplet.add(num[j]);
                        quadruplet.add(curStart);
                        quadruplet.add(curEnd);
                        result.add(quadruplet);
                        while(start < end &&  num[start] == curStart) {
                            start++;
                        }
                        while(end > start && num[end] == curEnd) {
                            end--;
                        }
                    }
                }
            }     
        }
        return result;       
    }
}
