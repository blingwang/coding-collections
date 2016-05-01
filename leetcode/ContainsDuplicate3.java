public class Solution {
    // Use value range as key. If the map already contains the same key, a valid pair is found. 
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || t < 0 || k < 1) return false;
        
        Map<Integer, Integer> buckets = new HashMap<>();
        int width = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int id = getBucketId(nums[i], width);
            
            if (buckets.containsKey(id)) return true;
            if (buckets.containsKey(id-1) && nums[i] - buckets.get(id-1) < width) return true;
            if (buckets.containsKey(id+1) && buckets.get(id+1) - nums[i] < width) return true;
                
            buckets.put(id, nums[i]); // each bucket contains at most one entry
            
            if (i >= k) buckets.remove(getBucketId(nums[i-k], width));
        }
        
        return false;
    }
    
    private int getBucketId(int i, int w) {
        return i < 0 ? ((i+1)/w - 1) : i/w;
    }
}
