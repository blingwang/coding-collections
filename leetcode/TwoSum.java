import java.util.*;

class TwoSum {
    /* return two int values */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
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
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
        }

        return result;
    }

    /* return two non-zero-based indexes */
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = {-1, -1};
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for(int i = 0; i < numbers.length; i++) {
            int expected = target - numbers[i];
            if (hmap.containsKey(expected)) {
                result[0] = hmap.get(expected) + 1;
                result[1] = i + 1;
                return result;
            }
            hmap.put(numbers[i], i);
        }

        return result;
    }
}
