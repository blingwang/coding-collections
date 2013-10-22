public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        
        int[] result = new int[digits.length+1];
        result[0] = 1;
        
        return result;
    }
    
    public int[] plusOne2(int[] digits) {
        int carrier = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carrier;
            
            if (sum < 10) {
                digits[i] = sum;
                return digits;
            }
            
            digits[i] = sum % 10;
            carrier = sum / 10;
        }
        
        int[] result = new int[digits.length+1];
        result[0] = 1;
        
        return result;
    }
}
