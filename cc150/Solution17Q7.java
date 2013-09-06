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
            return "Negative" + numToString(-1 * number);
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
            str += digits[number / 100 - 1] + " Hundred";
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
}

