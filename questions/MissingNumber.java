public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        
        int xor1 = 0;
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }
        
        int xor2 = nums[0];
        for (int i = 1; i < n; i++) {
            xor2 ^= nums[i];
        }
        
        return xor1^xor2;
    }
}
