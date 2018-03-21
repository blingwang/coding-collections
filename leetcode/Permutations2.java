class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        enumerate(nums, 0, permutations);
        return permutations;
    }
    
    private void enumerate(int[] nums, int curIndex, List<List<Integer>> permutations) {
        if (curIndex == nums.length) {
            permutations.add(createPermutation(nums));
            return;
        }
        
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int i = curIndex; i < nums.length; i++) {
            if (seen.contains(nums[i])) continue;
            seen.add(nums[i]);
            swap(nums, curIndex, i);
            enumerate(nums, curIndex + 1, permutations);
            swap(nums, curIndex, i);
        }
    }
    
    private List<Integer> createPermutation(int[] nums) {
        List<Integer> permutation = new ArrayList<>();
        for (int i : nums) {
            permutation.add(i);
        }
        return permutation;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
