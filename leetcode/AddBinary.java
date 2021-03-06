public class AddBinary {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        char[] result = new char[length];
        
        int carrier = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        for (int k = length - 1; k >= 0; k--) {
            int val1 = 0, val2 = 0;
            if (i >= 0) val1 = a.charAt(i--) - '0';
            if (j >= 0) val2 = b.charAt(j--) - '0';
            
            int sum = val1 + val2 + carrier;
            result[k] = (sum % 2 == 0) ? '0' : '1';
            carrier = sum / 2;
        }
        
        String binaryStr = new String(result);
        if (carrier == 1) binaryStr = "1" + binaryStr;
        return binaryStr;
    }
    
    public String addBinary2(String a, String b) {
        int length = Math.max(a.length(), b.length());
        char[] result = new char[length];
        
        int carrier = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        for (int k = length - 1; k >= 0; k--) {
            int sum = 0;
            if (i < 0) sum = b.charAt(j--) - '0' + carrier;
            else if ( j < 0) sum = a.charAt(i--) - '0' + carrier;
            else sum = a.charAt(i--) - '0' + b.charAt(j--) - '0' + carrier;
            result[k] = (char)(sum % 2 + '0');
            carrier = sum / 2;
        }
        
        String binaryStr = new String(result);
        if (carrier == 1) binaryStr = "1" + binaryStr;
        return binaryStr;
    }
}
