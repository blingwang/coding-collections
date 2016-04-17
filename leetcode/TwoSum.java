import java.util.*;

class TwoSum {
    /* return two int values */
    public int[] twoSum(int[] numbers, int target) {
        int[] pair = new int[2];
        Arrays.sort(numbers);
        int start = 0;
        int end = numbers.length - 1;

        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                pair[0] = numbers[start];
                pair[1] = numbers[end];
                return pair;
            }
        }

        return pair;
    }

    /* return two non-zero-based indexes */
    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = {-1, -1};
            Map<Integer, Integer> indexMap = new HashMap<>();
            
            for (int i = 0; i < nums.length; i++) {
                int expected = target - nums[i];
                
                if (indexMap.containsKey(expected)) {
                    result[0] = indexMap.get(expected);
                    result[1] = i;
                    return result;
                }
                
                indexMap.put(nums[i], i);
            }
            
            return result;
        }
    }
}
