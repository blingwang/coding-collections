class Solution17Q7 {
    private static final String[] digits = {"One", "Two", "Three", "Four", "Five",
                                            "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Eleven", "Twelve", "Thirteen", 
                                           "Fourteen", "Fifteen", "Sixteen", 
                                           "Seventeen", "Eighteen", "Ninetee"};
    private static final String[] tens = {"Ten", "Twenty", "Thirty", "Forty", 
                                          "Fifty", "Sixty", "Seventy", "Eighty",
                                          "Ninety"};
    private static final String[] bigs = {"", "Thousand", "Million", "Billion"};

    public static String numToString(int number) {
        if (number == 0) {
            return "Zero";
        } else if (number < 0) {
            return "Negative" + numToString(-number);
        }

        int count = 0;
        String str = "";

        while (number > 0) {
            if (number % 1000 != 0) {
                str = numToString100(number % 1000) + bigs[count] + " " + str;
            }

            number /= 1000;
            count++;
        }

        return str;
    }

    public static String numToString100(int number) {
        String str = "";

        // Convert hundreds place
        if (number >= 100) {
            str += digits[number / 100 - 1] + " Hundred ";
            number %= 100;
        }

        // Convert tens place
        if (number >= 11 && number <= 19) {
            return str + teens[number - 11] + " ";
        } else if (number == 10 || number >= 20) {
            str += tens[number / 10 - 1] + " ";
            number %= 10;
        }

        // Convert ones place
        if (number >= 1 && number <= 9) {
            str += digits[number - 1] + " ";
        }

        return str;
    }
    
    public static String numToString2(int number) {
        if (number == 0) return "Zero";
        if (number < 0) return "Negative " + numToString(-number);
        
        return convertThousands(number);
    }
    
    private static String convertThousands(int number) {
        int count = 0;
        String str = "";

        while (number > 0) {
            if (number % 1000 != 0) {
                str = convertHundreds(number % 1000) + thousands[count] + " " + str;
            }      
            number /= 1000;
            count++;
        }
        
        return str;
    }
    
    private static String convertHundreds(int number) {
        assert(number < 1000);
        StringBuilder sb = new StringBuilder();
        
        if (number >= 100) {
            sb.append(digits[number/100-1]);
            sb.append(" Hundred ");
        }
        
        sb.append(convertTens(number % 100));
        
        return sb.toString();
    }
    
    private static String convertTens(int number) {
        assert(number < 100);
        
        StringBuilder sb = new StringBuilder();
        if (number >= 11 && number <= 19) {
            sb.append(teens[number-11]);
            sb.append(" ");
        } else if (number == 10 || number >= 20){
            sb.append(tens[number/10 - 1]);
            sb.append(" ");
        }
        
        sb.append(convertOnes(number % 10));
        
        return sb.toString();
    }
    
    private static String convertOnes(int number) {
        assert(number >= 0 && number < 10);
        StringBuilder sb = new StringBuilder();
       
        if (number > 0) {
            sb.append(digits[number-1]);
            sb.append(" ");
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(numToString(56789));
    }
}

