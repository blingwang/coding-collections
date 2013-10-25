public class CountAndSay {
    public String countAndSay(int n) {
        assert(n > 0);
        StringBuilder result = new StringBuilder();
        result.append(1);
        
        for (int i = 1; i < n; i++) {
            StringBuilder ith = new StringBuilder();
            int count = 1;
            char preDigit = result.charAt(0);
            
            for (int j = 1; j < result.length(); j++) {
                char curDigit = result.charAt(j);
                if (curDigit == preDigit) {
                    count++;
                } else {
                    ith.append(count);
                    ith.append(preDigit);
                    preDigit = curDigit;
                    count = 1;
                }
            }
            
            ith.append(count);
            ith.append(preDigit);
            result = ith;
        }
        
        return result.toString();
    }
}
