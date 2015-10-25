public class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int len = nums.length;
            if ( i-1 < 0 && i+1 == len) return i;
            if (i-1 < 0 && i+1 < len && nums[i] > nums[i+1]) return i;
            if (i-1 >= 0 && i+1 == len && nums[i] > nums[i-1]) return i;
            if (i-1 >= 0 && i+1 < len && nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        
        return -1;
    }
}
