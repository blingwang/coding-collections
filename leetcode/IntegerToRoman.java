public class IntegerToRoman {
    private static final String[] thousands = {"", "M", "MM", "MMM"}; 
    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", 
                                              "DC", "DCC", "DCCC", "CM" }; 
    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", 
                                          "LX", "LXX", "LXXX", "XC" }; 
    private static final String[] ones = {"", "I", "II", "III", "IV", "V", 
                                          "VI", "VII", "VIII", "IX" };

    public String intToRoman1(int num) {
        assert(num >= 1 && num <= 3999);
        StringBuilder result = new StringBuilder();
        
        int thousand = num / 1000;
        num = num % 1000;
        int hundred = num / 100;
        num = num % 100;
        int ten = num / 10;
        int one = num % 10;
        
        result.append(thousands[thousand]);
        result.append(hundreds[hundred]);
        result.append(tens[ten]);
        result.append(ones[one]);
        
        return result.toString();
    }

    public String intToRoman(int num) {
        final char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        String result = "";
        
        for (int base = 0; num > 0; num /= 10, base += 2) {
            int digit = num % 10;
            switch (digit) {
                case 1: 
                case 2:
                case 3:
                    while (digit > 0) {
                        result = romans[base] + result;
                        digit--;
                    }
                    break;
                case 4: 
                    result = romans[base+1] + result;
                    result = romans[base] + result;
                    break;
                case 5:
                    result = romans[base+1] + result;
                    break;
                case 6:
                case 7:
                case 8:
                    while (digit > 5) {
                        result = romans[base] + result;
                        digit--;
                    }
                    result = romans[base+1] + result;
                    break;
                case 9:
                    result = romans[base+2] + result;
                    result = romans[base] + result;
                    break;
                default:
                    break;
            }
        }
        
        return result;
    } 
}
