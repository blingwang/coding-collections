public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        assert(!num1.isEmpty() && !num2.isEmpty());
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int l1 = num1.length(), l2 = num2.length();
        int[] result = new int[l1+l2];
        
        for (int i = l1 - 1; i >= 0; i--) {
            int val1 = num1.charAt(i) - '0';
            for (int j = l2 - 1; j >= 0; j--) {
                int val2 = num2.charAt(j) - '0';
                int sum = result[i+j+1]+ val1 * val2;
                result[i+j+1] = sum % 10;
                result[i+j] += sum / 10;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        if (result[0] != 0) answer.append(result[0]);
        for (int i = 1; i < result.length; i++) {
            answer.append(result[i]);
        }
        
        return answer.toString();
    }
    
    public String multiply2(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        assert (m != 0 && n != 0);
        int[] result = new int[m+n];
        
        for (int i = m-1; i >= 0; i--) {
            int carrier = 0;
            int d1 = num1.charAt(i) - '0';
            for (int j = n-1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                // result array: [len1+len2]
                // sliding len2 from end to mid
                int curIndex = i + j + 1; // consider end case: m+n-1
                
                // sum product and previous values
                int curValue = d1 * d2 + carrier + result[curIndex];
                carrier = curValue / 10;
                result[curIndex] = curValue % 10;
            }
            result[i] = carrier; // consider start case: 0
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0 && ans.length() == 0) continue;
            ans.append(result[i]);
        }
        
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
