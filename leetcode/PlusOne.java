public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length]; // keep original?
        int carrier = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carrier == 0) {
                result[i] = digits[i];
                continue;
            }
            int sum = digits[i] + carrier;
            result[i] = sum % 10;
            carrier = sum / 10;
        }
        
        if (carrier != 0) {
            int[] ret = new int[result.length+1];
            for (int i = 0; i < result.length; i++) {
                ret[i+1] = result[i];
            }
            
            ret[0] = carrier;
            return ret;
        }
        
        return result;
    }
}
