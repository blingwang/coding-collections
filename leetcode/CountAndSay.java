public class CountAndSay {
    public String countAndSay(int n) {
        assert(n > 0);
        StringBuilder result = new StringBuilder();
        result.append(1);
        
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            char preValue = result.charAt(0);
            int preCount = 1;
            
            for (int j = 1; j < result.length(); j++) {
                char c = result.charAt(j);
                if (c == preValue) {
                    preCount++;
                } else {
                    temp.append(preCount);
                    temp.append(preValue);
                    preValue = c;
                    preCount = 1;
                }
            }
            temp.append(preCount);
            temp.append(preValue);       
            result = temp;
        }
        return result.toString();     
    }
}
