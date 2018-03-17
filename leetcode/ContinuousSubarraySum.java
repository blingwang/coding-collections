class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            if (!map.containsKey(runningSum)) {
                map.put(runningSum, i);
            } else if (map.get(runningSum) < i - 1) {
                return true;
            }
            
        }
        
        return false;
    }
}
