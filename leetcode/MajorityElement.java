public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            
            if (!count.containsKey(num)) {
                count.put(num, 1);
            } else {
                count.put(num, count.get(num) + 1);
            } 
            
            if (count.get(num) > n/2) return num;
        }
        
        return nums[0];
    }
}
