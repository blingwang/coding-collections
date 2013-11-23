public class LongParser {
    /**
     * Parses the string argument as a signed decimal long.
     * The characters in the string must all be decimal digits,
     * except that the first character may be "+"/"-".
     *
     * For example:
     * "123"    => 123L
     * "-123"   => -123L
     * "a8"     => NumberFormatException
     * "-"      => NumberFormatException
     *
     * Limitations: this method does not handle overflow
     * If the string contains a number beyond long value limits, it will overflow.
     *
     * @param s a string to be parsed to long
     * @return the long represented by the argument in decimal.
     * @throws NumberFormatException if the string is not a valid long.
     */
    public long stringToLong(String s) throws NumberFormatException{
        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (s.length() == 0) {
            throw new NumberFormatException("empty string");
        }

        long result = 0;
        boolean negative = false;
        int firstDigitIndex = 0;
        char firstChar = s.charAt(0);

        // parse leading sign
        if (firstChar == '-') {
            negative = true;
            firstDigitIndex++;
        } else if (firstChar == '+') {
            firstDigitIndex++;
        }

        if (firstDigitIndex == s.length()) { // no digits in string
            throw new NumberFormatException("invalid input: " + s);
        }

        // parse unsigned long
        for (int i = firstDigitIndex; i < s.length(); i++) {
            char digit = s.charAt(i);

            if (digit < '0' || digit > '9') {
                throw new NumberFormatException("invalid input: " + s);
            }

            int digitValue = digit - '0';
            result = result * 10 + digitValue;
        }

        return negative ? -result : result;
    }

    public void testStringToLong() {
        assert(stringToLong("123") == 123L);
        assert(stringToLong("0") == 0L);
        assert(stringToLong("-0") == 0L);
        assert(stringToLong("+11") == 11L);
        assert(stringToLong("+001") == 1L);
        assert(stringToLong("-010") == 10L);
        assert(stringToLong("-123456789") == -123456789L);
        assert(stringToLong("6666666666") == 6666666666L);

        try {
            stringToLong("");
            System.out.println("failure: +");
        } catch (NumberFormatException e) {
            System.out.println("success");
        }
        
        try {
            stringToLong("+");
            System.out.println("failure: +");
        } catch (NumberFormatException e) {
            System.out.println("success");
        }

        try {
            stringToLong("88a6");
            System.out.println("failure: 88a6");
        } catch (NumberFormatException e) {
            System.out.println("success");
        }
    }

    public static void main(String[] args) {
        LongParser lp = new LongParser();
        lp.testStringToLong();
    }
}
