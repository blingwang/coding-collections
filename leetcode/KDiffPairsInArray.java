class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int count = 0;
        if (k == 0) {
            for (int val : map.values()) {
                if (val >= 2) count++;
            }
            return count;
        }
        
        for (int key : map.keySet()) {
            if (map.containsKey(key + k)) {
                count++;
            }
        }
        
        return count;
    }
}
