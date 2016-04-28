import java.util.*;

public class Solution {
    public int findKthLargestSorting(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
    
    public int findKthLargestMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i : nums) {
            heap.offer(i);
            if (heap.size() > k) heap.poll();
        }
        
        return heap.peek();
    }
    
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        
        return nums[k];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        
        while (true) {
            while (i < hi && nums[i] < nums[lo]) i++;
            while (j > lo && nums[j] > nums[lo]) j--;
            if (i >= j) break;
            swap(nums, i++, j--);
        }
        
        swap(nums, lo, j);
        return j;
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void shuffle(int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            swap(a, i, random.nextInt(i+1));
        }
    }
}
