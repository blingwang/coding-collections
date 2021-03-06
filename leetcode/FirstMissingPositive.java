class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);  
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
             
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
    
    public int firstMissingPositiveHashSet(int[] nums) {
        Set<Integer> positives = new HashSet<>();
        for (int i : nums) {
            if (i > 0 ) {
                positives.add(i);
            }
        }
        
        for (int i = 1; i <= positives.size(); i++) {
            if (!positives.contains(i)) {
                return i;
            }
        }
        
        return positives.size() + 1;
    }
}
