import java.util.*;
class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        assert(num.length >= 3);
        Arrays.sort(num);
        int closestSum = num[0] + num[1] + num[2];
        
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            
            int start = i + 1; 
            int end = num.length - 1;
            
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                
                if (sum == target) {
                    return target;
                }
                
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return closestSum;
    }
}
