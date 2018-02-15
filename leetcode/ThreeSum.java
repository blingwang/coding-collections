import java.util.*;

public class ThreeSum {
    /* Solution 1 using two pointers*/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start-1]) {
                    start++;
                    continue;
                }
                
                if (end < nums.length - 1 && nums[end] == nums[end+1]) {
                    end--;
                    continue;
                }
                
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);
                    result.add(triplet);
                    start++;
                    end--;
                }
            }
        }
        
        return result;
    }
    
    /* Solution 2 using binary search */
    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
        for (int i = 0; i < num.length-2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            
            for (int j = i+1; j < num.length-1; j++) {
                if (j > i+1 && num[j] == num[j-1]) continue;
                
                int expected = -(num[i] + num[j]);
                int k = binarySearch(num, j+1, num.length-1, expected);
                if (k < 0) continue;
                
                ArrayList<Integer> triplet = new ArrayList<Integer>();
                triplet.add(num[i]);
                triplet.add(num[j]);
                triplet.add(num[k]);
                result.add(triplet);
            }
        }
        
        return result;
    }
    
    private int binarySearch(int[] a, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) return mid;
            if (a[mid] < target) lo = mid + 1;
            else                 hi = mid - 1;
        }
        return -1;
    }
}
