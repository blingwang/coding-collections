class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        
        for (int i: nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                result[0] = Math.abs(i);
            } else {
                nums[Math.abs(i) - 1] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
            }
        }
        
        return result;
    }
    
    public int[] findErrorNums2(int[] nums) {
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1 );
            }    
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result[0] = nums[i];
                result[1] = i + 1;
            }
        }
        
        return result;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
