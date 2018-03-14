class Solution {
    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;
        for (int i : nums) {
            int max = Math.max(pre + i, cur);
            pre = cur;
            cur = max;
        }
        return cur;
    }
}
