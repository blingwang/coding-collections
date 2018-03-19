class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int max = nums[0];  
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }
            maxEndingHere = Math.max(maxEndingHere * cur, cur);
            minEndingHere = Math.min(minEndingHere * cur, cur);
            max = Math.max(max, maxEndingHere);
        }
        
        return max;
    }
}
