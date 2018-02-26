class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Check nums[nums[i] - 1] != nums[i] to handle duplicates
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        } 
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int firstMissingPositiveUsingSet(int[] nums) {
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
