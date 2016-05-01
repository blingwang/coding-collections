public class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder maxNum = new StringBuilder();
        String[] numStrings = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }   
        
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a+b).compareTo(b+a);
            }
        };
        
        Arrays.sort(numStrings, comparator);
        
        for (int i = numStrings.length - 1; i >= 0; i--) {
            maxNum.append(numStrings[i]);   
        }
        
        if (maxNum.charAt(0) == '0') return "0";
        
        return maxNum.toString();
    }
}
