public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n];
        
        for (int i = m-1; i >= 0; i--) {
            int carrier = 0;
            int d1 = num1.charAt(i) - '0';
            for (int j = n-1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int product = d1 * d2;
                result[i+j+1] += product + carrier;
                carrier = result[i+j+1] / 10;
                result[i+j+1] %= 10;
            }
            result[i] = carrier;
        }
        
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0 && ans.length() == 0) continue;
            ans.append(result[i]);
        }
        
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
