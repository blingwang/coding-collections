public class Solution {
    /* Voting algorithm */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = nums[0];
        int counter = 0;
        
        for (int num : nums) {
            if (counter == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                counter++;
            } else {
                counter--;
            }
        }
        
        counter = 0;
        for (int num : nums) {
            if (num == candidate) counter++;
        }
        
        if (counter > n / 2) return candidate;
        
        return -1;
    }
    
    public int majorityElementLinearSpace(int[] nums) {
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
