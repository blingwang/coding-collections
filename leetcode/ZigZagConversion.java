public class ZigZagConversion {
    public String convert(String s, int nRows) {
        assert(s != null);
        if (nRows <= 1) return s;
        
        StringBuilder result = new StringBuilder();
        int diff = nRows + nRows -2;
        
        for (int row = 0; row < nRows; row++) {
            for (int i = row; i < s.length(); i += diff) {
                result.append(s.charAt(i));
                int nextIndex = i + diff - row - row;
                if (row != 0 && row != nRows-1 && nextIndex < s.length()) {
                    result.append(s.charAt(nextIndex));
                }
            }
            
        }
        
        return result.toString();
    }
}
