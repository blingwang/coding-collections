public class Solution {
    // If the array is in order, I prefer Binary Search method. Otherwise, the XOR method is better.
    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i< nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
    
    public int missingNumberSum(int[] nums) { //sum
        int len = nums.length;
        int sum = (0+len)*(len+1)/2;
        for(int i=0; i<len; i++)
            sum-=nums[i];
        return sum;
    }

    public int missingNumberBinarySearch(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}
