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

        throw new IllegalArgumentException("No two sum solution");
    }

    /* return two indexes */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] pair = {-1, -1};
            Map<Integer, Integer> valToIndex = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int want = target - nums[i];

                if (valToIndex.containsKey(want)) {
                    pair[0] = valToIndex.get(want);
                    pair[1] = i;
                    return pair;
                }

                valToIndex.put(nums[i], i);
            }

            return pair;
        }
    }
